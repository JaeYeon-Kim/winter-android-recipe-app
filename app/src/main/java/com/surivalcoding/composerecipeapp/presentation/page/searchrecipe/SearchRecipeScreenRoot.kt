package com.surivalcoding.composerecipeapp.presentation.page.searchrecipe

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun SearchRecipeScreenRoot(
    onRecipeDetailClick: (Int) -> Unit,
    viewModel: SearchRecipeViewModel = hiltViewModel()
) {
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    snackBarHostState.showSnackbar(event.message)
                }

            }
        }
    }

    Scaffold(
        containerColor = AppColors.white,
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) { contentPadding ->
        SearchRecipeScreen(
            state = viewModel.searchRecipeState.collectAsStateWithLifecycle().value,
            onAction = { action ->
                when (action) {
                    is SearchRecipeAction.SearchRecipeDetail -> {
                        Logger.e("디테일 화면으로 이동해버려!")
                        onRecipeDetailClick(action.recipeDetail.id)     // recipe id 값을 넘김
                    }

                    else -> viewModel.onAction(action)
                }
            }
        )
    }

}