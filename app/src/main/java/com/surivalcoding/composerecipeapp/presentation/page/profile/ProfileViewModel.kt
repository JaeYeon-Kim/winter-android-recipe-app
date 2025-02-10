package com.surivalcoding.composerecipeapp.presentation.page.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.usecase.GetAllRecipesUseCase
import com.surivalcoding.composerecipeapp.util.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getAllRecipesUseCase: GetAllRecipesUseCase
) : ViewModel() {

    private val _profileState = MutableStateFlow(ProfileState())
    val profileState = _profileState.asStateFlow()

    init {
        getMainRecipe()
    }

    // Room에 저장한 리스트를 다 들고옴(Home에서 통신을 통해 저장하기 때문에 Profile에서는 저장되어 있는 상태)
    private fun getMainRecipe() {
        viewModelScope.launch {
            getAllRecipesUseCase.execute().collect { result ->
                when (result) {
                    is ResponseResult.Success -> {
                        _profileState.update {
                            it.copy(
                                recipeList = result.data
                            )
                        }
                    }

                    is ResponseResult.Failure -> {

                    }
                }
            }
        }

    }

    fun onAction(action: ProfileAction) {
        when (action) {
            is ProfileAction.FilterCategory -> {
                _profileState.value = _profileState.value.copy(
                    filterButtonState = action.filterButtonState
                )
            }

            ProfileAction.MoreButton -> Logger.e("더보기 버튼 클릭!!")
        }
    }
}