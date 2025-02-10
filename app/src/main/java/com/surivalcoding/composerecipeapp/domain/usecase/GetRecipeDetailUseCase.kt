package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.repository.SavedRecipeRepository
import com.surivalcoding.composerecipeapp.util.safeCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetRecipeDetailUseCase @Inject constructor(
    private val savedRecipeRepository: SavedRecipeRepository
) {
    suspend fun execute(id: Int) = withContext(Dispatchers.IO) {
        safeCall {
            savedRecipeRepository.getRecipeDetail(id)
        }
    }
}