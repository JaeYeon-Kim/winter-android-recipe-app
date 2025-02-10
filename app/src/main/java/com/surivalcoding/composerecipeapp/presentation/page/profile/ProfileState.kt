package com.surivalcoding.composerecipeapp.presentation.page.profile

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class ProfileState(
    val filterButtonState: FilterButtonState = FilterButtonState(),
    val recipeList: List<Recipe> = emptyList()
)

