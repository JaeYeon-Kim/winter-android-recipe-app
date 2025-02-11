package com.surivalcoding.composerecipeapp.presentation.page.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.usecase.AddBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.DeleteBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetAllRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetMainRecipeListUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.SaveAllRecipesUseCase
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Category
import com.surivalcoding.composerecipeapp.util.NetworkManager
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMainRecipeListUseCase: GetMainRecipeListUseCase,     // 통신을 통해 불러오기
    private val addBookmarkUseCase: AddBookmarkUseCase,                 // 북마크 추가
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,           // 북마크 삭제
    private val saveAllRecipesUseCase: SaveAllRecipesUseCase,           // Room에 전체 저장
    private val getAllRecipesUseCase: GetAllRecipesUseCase,             // 현재 Room에 저장된 레시피 다들고 오기
) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()



    init {
        getMainRecipeList()
        observeMainRecipeList()
    }

    // 홈의 메인 레시피 불러오기
    private fun getMainRecipeList() {
        viewModelScope.launch {
            when (val result = getMainRecipeListUseCase.execute()) {
                is ResponseResult.Success -> {
                    _homeState.update {
                        it.copy(
                            recipeList = result.data,
                            filteredRecipeList = result.data,
                            newRecipeList = result.data.take(5)
                        )
                    }

                    // 전체 리스트 Room에 저장
                    saveAllRecipesUseCase.execute(result.data).also {
                        // 홈화면 제일 하단 메인 리스트 5개 불러오기(추후에 수정필요)
                        getNewRecipeList()
                    }

                }

                is ResponseResult.Failure -> {
                    Logger.e("홈 화면 통신 불러오기 실패")
                    _homeState.update {
                        it.copy(
                            recipeList = emptyList(),
                            filteredRecipeList = emptyList(),
                            newRecipeList = emptyList()
                        )
                    }
                }
            }

        }
    }

    // 카테고리 클릭 처리
    private fun onSelectCategory(pickerState: PickerState) {
        _homeState.update {
            it.copy(pickerState = pickerState)
        }

        // 필터링된 레시피 리스트 갱신
        _homeState.update { state ->
            val filteredList = if (pickerState.buttonState.displayName == Category.All.displayName) {
                state.recipeList
            } else {
                state.recipeList.filter { recipe ->
                    recipe.category == pickerState.buttonState.displayName
                }
            }

            Logger.e("카피하기전 리스트 :${filteredList.size}")
            state.copy(filteredRecipeList = filteredList)
        }
    }

    // new Recipes 불러오기 -> 추후에 UseCase를 나누어서 날짜에 따라 최신순으로 불러와야할것 같음 현재 날자 데이터가 없어서 임시로 앞에서 부터 5개
    private fun getNewRecipeList() {
        viewModelScope.launch {
            // 전체 리스트에서 임시로 5개만 가져오기
            val newRecipeList = _homeState.value.recipeList.take(5)
            _homeState.update {
                it.copy(newRecipeList = newRecipeList)
            }
        }
    }


    // 메인 레시피 북마크 처리: 삭제와 추가가 토글 형식으로 동작하도록 처리
    private fun addBookmark(id: Int) {
        viewModelScope.launch {
            // 현재 레시피 리스트에서 해당 id의 북마크 상태 확인
            val isCurrentBookmarked = _homeState.value.recipeList.find { it.id == id }
                ?.isBookMarked ?: false

            if (isCurrentBookmarked) {
                // 이미 북마크된 상태라면 삭제 처리
                deleteBookmarkUseCase.execute(id)
            } else {
                addBookmarkUseCase.execute(id)
            }

            // id에 따라 북마크 상태 업데이트 (전체 리스트)
            val updatedRecipeList = _homeState.value.recipeList.map { recipe ->
                if (recipe.id == id) {
                    recipe.copy(isBookMarked = !isCurrentBookmarked)
                } else {
                    recipe
                }
            }

            // id에 따라 북마크 상태 업데이트 (필터 리스트)
            val updatedFilteredRecipeList = _homeState.value.filteredRecipeList.map { recipe ->
                if (recipe.id == id) {
                    recipe.copy(isBookMarked = !isCurrentBookmarked)
                } else {
                    recipe
                }
            }

            _homeState.update {
                it.copy(
                    recipeList = updatedRecipeList,
                    filteredRecipeList = updatedFilteredRecipeList
                )
            }
        }
    }


    // 홈에서 리스트 상태를 업데이트 해주는 메소드
    private fun observeMainRecipeList() {

        viewModelScope.launch {

            getAllRecipesUseCase.execute().collect { result ->
                when (result) {
                    is ResponseResult.Success -> {
                        _homeState.update {
                            it.copy(
                                recipeList = result.data,
                                filteredRecipeList = result.data,
                                newRecipeList = result.data.take(5)
                            )
                        }
                    }

                    is ResponseResult.Failure -> {
                        Logger.e("홈 화면 최신화 실패 ")
                    }
                }
            }
        }
    }


    /*
    * 사용자의 Action
    * */
    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.SearchRecipe -> Logger.e("Search Recipe 화면으로 이동")
            is HomeAction.FilterCategory -> onSelectCategory(pickerState = action.pickerState)
            is HomeAction.AddBookmark -> {      // 북마크 추가
                Logger.e("북마크 추가!!")
                addBookmark(action.id)
            }
            is HomeAction.RecipeDetail -> {
                Logger.e("레시피 상세 화면으로 이동")
            }
        }
    }
}