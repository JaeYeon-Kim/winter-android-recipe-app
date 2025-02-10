package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.repository.SavedRecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


/*
* saved 화면 Usecase
* */
class DeleteBookmarkUseCase @Inject constructor(
    private val savedRecipeRepository: SavedRecipeRepository
) {
    suspend fun execute(id: Int) = withContext(Dispatchers.IO) {
        savedRecipeRepository.deleteBookmark(id)
    }
}