package com.surivalcoding.composerecipeapp.data.datasource

import android.util.Log
import com.surivalcoding.composerecipeapp.data.dto.RecipeDto
import com.surivalcoding.composerecipeapp.data.dto.RecipeResponse
import com.surivalcoding.composerecipeapp.util.Urls
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class MockRecipeDataSourceImpl @Inject constructor() : RecipeDataSource {
    override suspend fun getRecipeList(): List<RecipeDto> = withContext(Dispatchers.IO) {
        val data = Urls.DEV_RECIPE_JSON

        return@withContext Json.decodeFromString<RecipeResponse>(data).recipes?.filterNotNull() ?: emptyList()
    }
}