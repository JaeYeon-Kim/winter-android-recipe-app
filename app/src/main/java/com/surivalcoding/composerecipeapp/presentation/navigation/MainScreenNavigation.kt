package com.surivalcoding.composerecipeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.surivalcoding.composerecipeapp.presentation.page.home.HomeScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.main.NotificationScreen
import com.surivalcoding.composerecipeapp.presentation.page.main.ProfileScreen
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.SavedRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.SavedRecipeScreenRoot
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipeScreenRoot


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

        composable(MainRoute.BookMark.screenRoute) {
            SavedRecipeScreenRoot()
        }

        composable(MainRoute.Notification.screenRoute) {
            NotificationScreen()
        }

        composable(MainRoute.Profile.screenRoute) {
            ProfileScreen()
        }

        composable(MainRoute.Search.screenRoute) {
            SearchRecipeScreenRoot()
        }
    }
}