package com.surivalcoding.composerecipeapp.presentation.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.presentation.page.home.HomeScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.main.NotificationScreen
import com.surivalcoding.composerecipeapp.presentation.page.profile.ProfileScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.recipe_detail.RecipeDetailScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.SavedRecipeScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipeScreenRoot
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Composable
fun MainScreenNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = MainRoute.Home.screenRoute) {
        composable(MainRoute.Home.screenRoute) {
            HomeScreenRoot(
                onSearchRecipeClick = {
                    navController.navigate(MainRoute.Search.screenRoute) {

                        popUpTo(MainRoute.Home.screenRoute) {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                }
            )
        }


        // 북마크 화면(SavedRecipeScreen)
        composable(
            route = MainRoute.BookMark.screenRoute
        ) {
            SavedRecipeScreenRoot(onRecipeDetailClick = { recipe ->
                val jsonRecipe = Uri.encode(Json.encodeToString(recipe))
                navController.navigate("${MainRoute.SearchDetail.screenRoute}/$jsonRecipe") {
                    popUpTo(MainRoute.BookMark.screenRoute) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            })
        }

        composable(MainRoute.Notification.screenRoute) {
            NotificationScreen()
        }

        composable(MainRoute.Profile.screenRoute) {
            ProfileScreenRoot()
        }

        // 검색 화면
        composable(MainRoute.Search.screenRoute) {
            SearchRecipeScreenRoot(onRecipeDetailClick = { recipeId ->
                navController.navigate("${MainRoute.SearchDetail.screenRoute}/$recipeId") {
                    popUpTo(MainRoute.Search.screenRoute) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            })
        }

        // 🔹 딥 링크로 레시피 상세 페이지 이동 가능하도록 추가
        composable(
            route = "${MainRoute.SearchDetail.screenRoute}/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType }),
            deepLinks = listOf(navDeepLink { uriPattern = "app://recipe.co/recipe/{recipeId}" })
        ) { backStackEntry ->
            val recipeId = backStackEntry.arguments?.getInt("recipeId")
            Logger.e("레시피 상세 화면 ID: $recipeId")
            recipeId?.let {
                RecipeDetailScreenRoot()
            }

        }

    }
}