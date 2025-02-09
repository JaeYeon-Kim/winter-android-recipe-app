package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.usecase.CopyLinkUseCase
import com.surivalcoding.composerecipeapp.domain.usecase.DeleteBookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val copyLinkUseCase: CopyLinkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _recipeDetailState = MutableStateFlow(RecipeDetailState())
    val recipeDetailState = _recipeDetailState.asStateFlow()

    init {
        // SearchRecipeScreen에서 해당 키값으로 데이터를 전달한후 여기서 받아서 처리함
        val jsonRecipe = savedStateHandle.get<String>("recipeDetail")
        Logger.e("디테일 정보: $jsonRecipe")


        // try - catch 대신 runCatching 사용
        kotlin.runCatching {
            jsonRecipe?.let {
                val recipe = Json.decodeFromString<Recipe>(it)
                _recipeDetailState.value = _recipeDetailState.value.copy(
                    recipeDetail = recipe
                )
            }
        }.onFailure {
            Logger.e("Error decoding recipeDetail")
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