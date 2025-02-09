package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class RecipeDetailState(
    val recipeDetail: Recipe? = null,
    val recipeCategoryButtonState: RecipeDetailButtonState = RecipeDetailButtonState(),
    val isDropDownMenuVisible: Boolean = false,
    val isShowShareDialog: Boolean = false,
    val isShowRateRecipeDialog: Boolean = false
)