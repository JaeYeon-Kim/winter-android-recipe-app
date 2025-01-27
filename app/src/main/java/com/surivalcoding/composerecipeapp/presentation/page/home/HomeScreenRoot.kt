package com.surivalcoding.composerecipeapp.presentation.page.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.presentation.page.main.HomeScreen


/*
* ViewModel의 의존성을 가지는 Screen의 래퍼를 만든다.
*
* 상태 관리 코드는 여기에만 작성
* 화면에서는 상태를 전달하고, 콜백을 처리
* */
@Composable
fun HomeScreenRoot(
    onSearchRecipeClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(
        state = viewModel.homeState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction
    )
}