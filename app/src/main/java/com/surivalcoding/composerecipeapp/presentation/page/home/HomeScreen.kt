package com.surivalcoding.composerecipeapp.presentation.page.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orhanobut.logger.Logger
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.MainRecipeItem
import com.surivalcoding.composerecipeapp.presentation.item.NewRecipeItem
import com.surivalcoding.composerecipeapp.presentation.item.button.NoneBorderFilterButton
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Category
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun HomeScreen(
    state: HomeState,
    onAction: (HomeAction) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
    ) {

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Hello Jega",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        fontSize = 20.sp, color = AppColors.black
                    )
                )

                Text(
                    text = "What are you cooking today?",
                    style = AppTextStyles.smallTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.gray_3
                    )
                )
            }

            Spacer(Modifier.weight(1f))


            Image(
                painter = painterResource(R.drawable.d6cbc6849fe48a0f9d7a0778502d14b5_removebg_preview_1),
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .background(color = AppColors.white)
                    .border(1.dp, color = AppColors.gray_4, shape = RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp)
                    .weight(1f)
                    .clickable { onAction(HomeAction.SearchRecipe) }, // 클릭 처리
                contentAlignment = Alignment.CenterStart // 텍스트와 아이콘 정렬
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = "search",
                        modifier = Modifier.size(18.dp),
                        tint = AppColors.gray_4
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Search recipe",
                        style = AppTextStyles.smallTextRegular.copy(
                            fontSize = 11.sp,
                            color = AppColors.gray_4
                        )
                    )
                }
            }

            // 필터 아이콘
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(AppColors.primary_100, shape = RoundedCornerShape(10.dp))
            ) {
                Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(R.drawable.setting_4),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // 필터아이콘 리스트
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 30.dp)
        ) {
            items(Category.entries) { category ->
                NoneBorderFilterButton(
                    text = category.name,
                    isSelected = state.pickerState.buttonState == category,
                    onClick = {
                        onAction(HomeAction.FilterCategory(PickerState(buttonState = category)))
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        // 메인 음식 리스트
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(start = 30.dp, end = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Logger.e("들어오는 리스트와 사이즈 ${state.filteredRecipeList.size} ${state.filteredRecipeList}")

            items(state.filteredRecipeList) { recipe ->
                MainRecipeItem(
                    recipe = recipe,
                    onBookMarkClick = { recipeId ->
                        onAction(HomeAction.AddBookmark(recipeId))
                    },
                    onItemClick = { recipeId ->
                        onAction(HomeAction.RecipeDetail(recipeId))
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // New Recipes 타이틀
        Text(
            text = "New Recipes",
            modifier = Modifier.padding(start = 30.dp),
            style = AppTextStyles.mediumTextSemiBold.copy(
                fontSize = 16.sp,
                color = AppColors.black
            )
        )

        Spacer(modifier = Modifier.height(5.dp))

        // NewRecipeList 가져오기
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 30.dp, end = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
        ) {
            itemsIndexed(state.newRecipeList) { index, recipe ->
                NewRecipeItem(
                    recipe = recipe,
                    itemIndex = index,
                    onItemClick = { recipeId ->
                        onAction(HomeAction.RecipeDetail(recipeId))
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        state = HomeState(),
        onAction = {}
    )
}