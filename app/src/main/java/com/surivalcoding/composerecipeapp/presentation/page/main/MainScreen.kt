package com.surivalcoding.composerecipeapp.presentation.page.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.navigation.BottomNavigationBar
import com.surivalcoding.composerecipeapp.presentation.navigation.MainRoute
import com.surivalcoding.composerecipeapp.presentation.navigation.MainScreenNavigation
import com.surivalcoding.composerecipeapp.ui.AppColors


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    // 상태로 관리해야 UI가 업데이트됨
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val items: List<MainRoute> = listOf(MainRoute.Home, MainRoute.BookMark, MainRoute.Notification, MainRoute.Profile)

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    showBottomBar = when (currentRoute) {
        MainRoute.Search.screenRoute -> false
        else -> true
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier
                        .height(72.dp),
                    cutoutShape = CircleShape,
                    backgroundColor = Color.White,
                ) {
                    BottomNavigationBar(currentRoute = currentRoute, items = items, navController = navController)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    shape = CircleShape,
                    onClick = { },
                    backgroundColor = AppColors.primary_100,
                ) {
                    Icon(
                        painter = painterResource(R.drawable.plus),
                        contentDescription = null,
                        tint = AppColors.white
                    )
                }
            }

        },
    ) { innerPadding ->
        MainScreenNavigation(navController = navController)
    }
}