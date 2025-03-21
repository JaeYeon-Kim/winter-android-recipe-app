package com.surivalcoding.composerecipeapp.domain.repository

import com.surivalcoding.composerecipeapp.domain.model.Recipe

interface RecipeRepository {
    suspend fun getRecipeList(): List<Recipe>
}