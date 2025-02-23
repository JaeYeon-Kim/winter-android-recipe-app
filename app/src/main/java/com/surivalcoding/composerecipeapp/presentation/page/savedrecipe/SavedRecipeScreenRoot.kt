package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.domain.model.Recipe

@Composable
fun SavedRecipeScreenRoot(
    onRecipeDetailClick: (Int) -> Unit,
    viewModel: SavedRecipeViewModel = hiltViewModel()
) {
    SavedRecipeScreen(
        state = viewModel.savedRecipeState.collectAsStateWithLifecycle().value,
        onAction = { action ->
            when (action) {
                // 클릭시 레시피 디테일 화면으로 이동
                is SavedRecipeAction.SearchRecipeDetail -> {
                    Logger.e("Saved 화면에서 레시피 디테일 화면 으로 이동 ")
                    onRecipeDetailClick(action.recipeId)
                }

                else -> viewModel.onAction(action)
            }
        }
    )
}