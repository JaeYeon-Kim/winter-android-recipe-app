package com.surivalcoding.composerecipeapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeResponse(
    val recipes: List<RecipeDto?>? = listOf()
)

@Serializable
data class RecipeDto(
    val category: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val image: String? = null,
    val chef: String? = null,
    val time: String? = null,
    val rating: Double? = null,
    val filterTime: String? = null,
    val isBookMarked: Boolean? = null,
    val video: String? = null,
    val ingredients: List<IngredientDto?>? = listOf(),
    val procedure: List<String>? = listOf()
)

@Serializable
data class IngredientDto(
    val ingredient: IngredientDetailDto? = null,
    val amount: Int? = null
)

@Serializable
data class IngredientDetailDto(
    val id: Int? = null,
    val name: String? = null,
    val image: String? = null
)
