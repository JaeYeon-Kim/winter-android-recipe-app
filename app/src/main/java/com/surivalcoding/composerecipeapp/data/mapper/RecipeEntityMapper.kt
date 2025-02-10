package com.surivalcoding.composerecipeapp.data.mapper

import com.surivalcoding.composerecipeapp.data.database.RecipeEntity
import com.surivalcoding.composerecipeapp.domain.model.Ingredient
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun RecipeEntity.toMapper(): Recipe {
    return Recipe(
        category = category,
        id = id,
        name = name,
        image = image,
        chef = chef,
        time = time,
        rating = rating,
        filterTime = filterTime,
        isBookMarked = isBookMarked == 1,
        video = video,
        ingredients = runCatching { Json.decodeFromString<List<Ingredient>>(ingredients) }.getOrElse { emptyList() },
        procedure = runCatching { Json.decodeFromString<List<String>>(procedure) }.getOrElse { emptyList() }
    )
}


fun Recipe.toMapper(): RecipeEntity {
    return RecipeEntity(
        category = category,
        id = id,
        name = name,
        image = image,
        chef = chef,
        time = time,
        rating = rating,
        filterTime = filterTime,
        isBookMarked = if (isBookMarked) 1 else 0,
        video = video,
        ingredients = Json.encodeToString(ingredients),
        procedure = Json.encodeToString(procedure)
    )
}