package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.repository.SearchPreferencesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveSearchKeywordUseCase @Inject constructor(
    private val searchPreferencesRepository: SearchPreferencesRepository
) {
    suspend fun execute(query: String) = withContext(Dispatchers.IO) {
        searchPreferencesRepository.saveLastSearchKeyword(query)
    }
}