package com.surivalcoding.composerecipeapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


/*
* Database 사용에 필요한 CRUD 명령 메소드 지정
* 데이터 접근 객체를 사용해 DB에 접근
* */
@Dao
interface RecipeDao {
    // 모든 레시피 가져오기
    @Query("SELECT * FROM recipes")
    fun getAllRecipes(): Flow<List<RecipeEntity>>

    // 북마크된 전체 리스트 가져오기
    @Query("SELECT * FROM recipes WHERE isBookMarked = 1")
    fun getBookmarkedRecipes(): Flow<List<RecipeEntity>>

    // 북마크 추가(isBookMarked -> 1로)
    @Query("UPDATE recipes SET isBookMarked = 1 WHERE id = :recipeId")
    suspend fun addBookmark(recipeId: Int)

    // 북마크 삭제(isBookMarked -> 0로)
    @Query("UPDATE recipes SET isBookMarked = 0 WHERE id = :recipeId")
    suspend fun removeBookmark(recipeId: Int)

    // 북마크된 레시피 ID 목록 가져오기
    @Query("SELECT id FROM recipes WHERE isBookMarked = 1")
    fun getBookmarkedRecipeIds(): List<Int>

    // recipeList 추가
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<RecipeEntity>)

    // ID를 이용한 레시피 상세 데이터 조회
    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    fun getRecipeById(recipeId: Int): RecipeEntity?
}