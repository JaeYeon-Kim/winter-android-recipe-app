package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.usecase.CopyLinkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.DeleteBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.GetRecipeDetailUseCase
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val copyLinkUseCase: CopyLinkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    private val getRecipeDetailUseCase: GetRecipeDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _recipeDetailState = MutableStateFlow(RecipeDetailState())
    val recipeDetailState = _recipeDetailState.asStateFlow()

    init {
        // 전달받은 id값을 받아줌
        val recipeId = savedStateHandle.get<Int>("recipeId")
        Logger.e("디테일 ID: $recipeId")

        recipeId?.let { id ->
            getRecipeDetail(id)
        }

    }


    // id 값을 통한 상세 데이터 조회
    private fun getRecipeDetail(id: Int) {
        viewModelScope.launch {
            when (val result = getRecipeDetailUseCase.execute(id)) {
                is ResponseResult.Success -> {
                    Logger.e("상세 데이터 조회: id: $id, result: $result")
                    _recipeDetailState.update {
                        it.copy(
                            recipeDetail = result.data
                        )
                    }
                }

                is ResponseResult.Failure -> {
                    Logger.e("레시피 상세 데이터 조회 실패")
                }
            }
        }
    }


    fun onAction(action: RecipeDetailAction) {
        when (action) {
            is RecipeDetailAction.FilterCategory -> {
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    recipeCategoryButtonState = action.recipeDetailButtonState
                )
            }

            is RecipeDetailAction.HandleDropDown -> {
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    isDropDownMenuVisible = action.isDropDownMenuVisible
                )

            }

            is RecipeDetailAction.CopyLink -> {
                copyLinkUseCase.execute(action.link)
            }

            // 드롭다운 - 공유
            is RecipeDetailAction.ShareRecipe -> {
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    isShowShareDialog = action.isVisible
                )
            }

            // 드롭다운 - Rate Recipe
            is RecipeDetailAction.RateRecipe -> {
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    isShowRateRecipeDialog = action.isVisible
                )
            }

            // 드롭다운 - 북마크 삭제
            is RecipeDetailAction.UnSaveRecipe -> {
                viewModelScope.launch {
                    deleteBookmarkUseCase.execute(action.id)
                }
            }
        }
    }
}