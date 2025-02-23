package com.surivalcoding.composerecipeapp.presentation.page.savedrecipe

import com.surivalcoding.composerecipeapp.domain.model.Recipe

sealed interface SavedRecipeAction {
    data class DeleteBookmark(val recipeId: Int) : SavedRecipeAction
    data class SearchRecipeDetail(val recipeId: Int) : SavedRecipeAction
}