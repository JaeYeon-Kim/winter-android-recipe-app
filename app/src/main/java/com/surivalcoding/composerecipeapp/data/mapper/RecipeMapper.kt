package com.surivalcoding.composerecipeapp.data.mapper


import com.surivalcoding.composerecipeapp.data.dto.IngredientDetailDto
import com.surivalcoding.composerecipeapp.data.dto.IngredientDto
import com.surivalcoding.composerecipeapp.data.dto.RecipeDto
import com.surivalcoding.composerecipeapp.domain.model.Ingredient
import com.surivalcoding.composerecipeapp.domain.model.IngredientDetail
import com.surivalcoding.composerecipeapp.domain.model.Recipe

fun RecipeDto.toMapper(): Recipe {
    return Recipe(
        category = category ?: "",
        id = id ?: 0,
        name = name ?: "",
        image = image ?: "",
        chef = chef ?: "",
        time = time ?: "",
        rating = rating ?: 0.0,
        filterTime = filterTime ?: "",
        isBookMarked = isBookMarked ?: false,
        video = video ?: "",
        ingredients = ingredients?.filterNotNull()?.map { it.toMapper() } ?: emptyList(),
        procedure = procedure ?: emptyList()
    )
}


fun IngredientDto.toMapper(): Ingredient {
    return Ingredient(
        ingredient = ingredient?.toMapper() ?: IngredientDetail(0, "", ""),
        amount = amount ?: 0
    )
}

fun IngredientDetailDto.toMapper(): IngredientDetail {
    return IngredientDetail(
        id = id ?: 0,
        name = name ?: "",
        image = image ?: ""
    )
}