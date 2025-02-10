package com.surivalcoding.composerecipeapp.domain.repository

import com.surivalcoding.composerecipeapp.data.database.RecipeEntity
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface SavedRecipeRepository {
    // 전체 레시피 리스트 가져오기
    fun getRecipeList(): Flow<List<Recipe>>

    // 전체 북마크 리스트 가져오기
    fun getAllBookMarkList(): Flow<List<Recipe>>

    // 북마크 삭제
    suspend fun deleteBookmark(id: Int)

    // 북마크 추가
    suspend fun addBookmark(id: Int)

    // 전체 레시피 저장
    suspend fun saveRecipeList(recipeList: List<Recipe>)

    // 레시피 상세 데이터 가져오기
    suspend fun getRecipeDetail(id: Int): Recipe?
}