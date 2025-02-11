package com.surivalcoding.composerecipeapp.presentation.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.RecipeCard
import com.surivalcoding.composerecipeapp.presentation.item.VideoItem
import com.surivalcoding.composerecipeapp.presentation.item.button.NoneBorderFilterButton
import com.surivalcoding.composerecipeapp.presentation.page.profile.FilterButtonState
import com.surivalcoding.composerecipeapp.presentation.page.profile.ProfileAction
import com.surivalcoding.composerecipeapp.presentation.page.profile.ProfileState
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.ProfileCategory
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun ProfileScreen(
    state: ProfileState,
    onAction: (ProfileAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.weight(1f),
                text = "Profile",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    color = AppColors.label_color
                ),
                textAlign = TextAlign.Center
            )

            IconButton(
                onClick = {},
                modifier = Modifier.size(24.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.more),
                    contentDescription = "more"
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            AsyncImage(
                model = R.drawable.test_profile_image,
                contentDescription = null,
                modifier = Modifier
                    .size(99.dp)
                    .clip(CircleShape)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Recipe",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.gray_3,
                        fontSize = 11.sp
                    )
                )

                Text(
                    text = "4",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        color = AppColors.label_color,
                        fontSize = 20.sp
                    )
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Followers",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.gray_3,
                        fontSize = 11.sp
                    )
                )

                Text(
                    text = "2.5M",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        color = AppColors.label_color,
                        fontSize = 20.sp
                    )
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Following",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.gray_3,
                        fontSize = 11.sp
                    )
                )

                Text(
                    text = "259",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        color = AppColors.label_color,
                        fontSize = 20.sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // chef Name
        Text(
            text = "Afuwape Abiodun",
            style = AppTextStyles.mediumTextSemiBold.copy(
                color = AppColors.label_color,
                fontSize = 16.sp,
            )
        )

        // job
        Text(
            text = "Chef",
            style = AppTextStyles.smallTextRegular.copy(
                color = AppColors.gray_3,
                fontSize = 11.sp,
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        // explanation
        Text(
            text = "Private Chef\nPassionate about food and life\nMore...",
            style = AppTextStyles.smallTextRegular.copy(
                color = AppColors.gray_2,
                fontSize = 11.sp
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        // 필터아이콘 리스트
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            ProfileCategory.entries.forEach { category ->
                NoneBorderFilterButton(
                    modifier = Modifier.weight(1f),
                    text = category.displayName,
                    isSelected = state.filterButtonState.buttonState == category,
                    onClick = {
                        onAction(
                            ProfileAction.FilterCategory(
                                filterButtonState = FilterButtonState(buttonState = category)
                            )
                        )
                    })
            }
        }

        Spacer(modifier = Modifier.height(23.dp))

        /*
        * 필터링에 따라 리스트 보여주는 처리 필요
        * */
        when (state.filterButtonState.buttonState) {
            // Recipe
            ProfileCategory.RECIPE -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(
                        state.recipeList,
                        key = { recipe -> recipe.id }
                    ) { recipe ->
                        RecipeCard(recipe = recipe)
                    }
                }
            }

            // Videos
            ProfileCategory.VIDEOS -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(
                        state.recipeList,
                        key = { recipe -> recipe.id }
                    ) { recipe ->
                        VideoItem(
                            videoUrl = recipe.video,
                            image = recipe.image
                        )
                    }
                }
            }


            ProfileCategory.TAG -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(
        state = ProfileState(),
        onAction = {}
    )
}