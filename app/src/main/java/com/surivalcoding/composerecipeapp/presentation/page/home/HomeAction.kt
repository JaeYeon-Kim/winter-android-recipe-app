package com.surivalcoding.composerecipeapp.presentation.page.home


sealed interface HomeAction {
    data class FilterCategory(val pickerState: PickerState) : HomeAction
    data object SearchRecipe : HomeAction
    data class AddBookmark(val id: Int) : HomeAction
    data class RecipeDetail(val id: Int) : HomeAction
}