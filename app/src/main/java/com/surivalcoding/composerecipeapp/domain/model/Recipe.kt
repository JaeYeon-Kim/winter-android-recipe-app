package com.surivalcoding.composerecipeapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val category: String,
    val id: Int,
    val name: String,
    val image: String,
    val chef: String,
    val time: String,
    val rating: Double,
    val filterTime: String,
    val isBookMarked: Boolean,
    val video: String,
    val ingredients: List<Ingredient>,
    val procedure: List<String>,
) {
    val ratingInt: Int
        get() = rating.toInt().coerceIn(1, 5) // Double을 Int로 변환 (1~5 범위 유지)
}


@Serializable
data class Ingredient(
    val ingredient: IngredientDetail,
    val amount: Int
)

@Serializable
data class IngredientDetail(
    val id: Int,
    val name: String,
    val image: String
)