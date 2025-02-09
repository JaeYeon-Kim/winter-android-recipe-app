package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

sealed interface RecipeDetailAction {
    data class FilterCategory(val recipeDetailButtonState: RecipeDetailButtonState) : RecipeDetailAction
    data class HandleDropDown(val isDropDownMenuVisible: Boolean) : RecipeDetailAction
    data class CopyLink(val link: String) : RecipeDetailAction
    data class ShareRecipe(val isVisible: Boolean) : RecipeDetailAction
    data class RateRecipe(val isVisible: Boolean): RecipeDetailAction
}