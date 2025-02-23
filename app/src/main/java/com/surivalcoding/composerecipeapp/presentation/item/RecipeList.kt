package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.SavedRecipeAction
import com.surivalcoding.composerecipeapp.presentation.page.savedrecipe.SavedRecipeState
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipeAction
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipesState


// RecipeList
@Composable
fun RecipeList(state: SavedRecipeState, onAction: (SavedRecipeAction) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(start = 30.dp, end = 30.dp, bottom = 80.dp)
    ) {
        items(
            items = state.bookMarkList,
            key = { it.id }
        ) { recipe ->
            RecipeCard(
                recipe = recipe,
                onItemClick = { id ->
                    onAction(SavedRecipeAction.SearchRecipeDetail(id))
                },
                onDeleteBookMark = { id ->
                    onAction(SavedRecipeAction.DeleteBookmark(id))
                }
            )
        }
    }
}

@Composable
fun RecipeListGrid(
    state: SearchRecipesState,
    onAction: (SearchRecipeAction) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(state.filteredRecipeList) { recipe ->
            RecipeCardSquare(
                recipe,
                onAction = onAction
            )
        }
    }
}