package com.surivalcoding.composerecipeapp.util


// 앱 전역에서 공통으로 쓰는 것들을 모아놓음
object CommonUtils {

    fun generateRecipeDeepLink(recipeId: Int): String {
        return "app://recipe.co/recipe/$recipeId"
    }
}