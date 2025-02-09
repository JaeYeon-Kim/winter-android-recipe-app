package com.surivalcoding.composerecipeapp.presentation.page.recipe_detail

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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.DropDownMenuWithDetails
import com.surivalcoding.composerecipeapp.presentation.item.IngredientItem
import com.surivalcoding.composerecipeapp.presentation.item.ProcedureCard
import com.surivalcoding.composerecipeapp.presentation.item.RecipeCard
import com.surivalcoding.composerecipeapp.presentation.item.button.NoneBorderFilterButton
import com.surivalcoding.composerecipeapp.presentation.item.button.PushedButton
import com.surivalcoding.composerecipeapp.presentation.item.dialog.RatingDialog
import com.surivalcoding.composerecipeapp.presentation.item.dialog.RecipeLinkDialog
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.RecipeDetailCategory
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun RecipeDetailScreen(
    state: RecipeDetailState,
    onAction: (RecipeDetailAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
    ) {

        Spacer(modifier = Modifier.height(12.dp))


        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                modifier = Modifier.size(24.dp),
                onClick = {
                    onAction(
                        RecipeDetailAction.HandleDropDown(
                            isDropDownMenuVisible = !state.isDropDownMenuVisible
                        )
                    )
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.more),
                    contentDescription = null,
                )

                DropDownMenuWithDetails(
                    isExpanded = state.isDropDownMenuVisible,
                    onDismissRequest = {
                        onAction(
                            RecipeDetailAction.HandleDropDown(
                                isDropDownMenuVisible = false
                            )
                        )
                    },
                    // 공유 버튼 클릭시
                    onShareClick = {
                        // 드롭다운 메뉴를 닫고 -> 다이얼로그를 띄움
                        onAction(RecipeDetailAction.HandleDropDown(false))
                        onAction(RecipeDetailAction.ShareRecipe(true))
                    },

                    // Rate Recipe 클릭시
                    onRateRecipeClick = {
                        // 드롭다운 메뉴를 닫고 -> 다이얼로그를 띄움
                        onAction(RecipeDetailAction.HandleDropDown(false))
                        onAction(RecipeDetailAction.RateRecipe(true))
                    }
                )
            }
        }

        // share 다이얼로그 
        if (state.isShowShareDialog) {
            RecipeLinkDialog(
                recipeId = state.recipeDetail?.id ?: 1,
                onCopyLink = { link ->
                    onAction(
                        RecipeDetailAction.CopyLink(link)
                    )
                },
                onDismiss = {
                    onAction(
                        RecipeDetailAction.ShareRecipe(false)
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        state.recipeDetail?.let { recipeDetail ->
            RecipeCard(
                recipe = recipeDetail,
                isDetail = true
            )
        }

        Spacer(modifier = Modifier.height(10.dp))


        // 음식명과 리뷰
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            Text(
                modifier = Modifier.weight(2f),
                text = state.recipeDetail?.name ?: "",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    fontSize = 14.sp,
                    color = AppColors.black
                )
            )

            Text(
                modifier = Modifier.weight(1f),
                text = "(13k Reviews)",
                style = AppTextStyles.smallTextRegular.copy(
                    color = AppColors.gray_3,
                    fontSize = 14.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // 프로필 사진, 이름, 지역, 팔로우버튼
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = R.drawable.test_profile_image,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = state.recipeDetail?.chef ?: "",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        fontSize = 14.sp,
                        color = AppColors.label_color
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.location),
                        contentDescription = null,
                        tint = AppColors.primary_80
                    )

                    Text(
                        text = "Lagos,Nigeria",
                        style = AppTextStyles.smallTextRegular.copy(
                            color = AppColors.gray_3,
                            fontSize = 11.sp
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            PushedButton(
                text = "Follow"
            )
        }


        Spacer(modifier = Modifier.height(20.dp))


        // 필터 버튼 리스트
        // 필터아이콘 리스트
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            RecipeDetailCategory.entries.forEach { category ->
                NoneBorderFilterButton(
                    modifier = Modifier.weight(1f),
                    text = category.displayName,
                    isSelected = state.recipeCategoryButtonState.buttonState == category,
                    onClick = {
                        onAction(
                            RecipeDetailAction.FilterCategory(
                                recipeDetailButtonState = RecipeDetailButtonState(
                                    buttonState = category
                                )
                            )
                        )
                    })
            }
        }

        Spacer(modifier = Modifier.height(39.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                modifier = Modifier.size(17.dp),
                painter = painterResource(R.drawable.hot_food),
                contentDescription = null
            )

            Text(
                text = "1 serve",
                style = AppTextStyles.smallTextRegular.copy(
                    color = AppColors.gray_3,
                    fontSize = 11.sp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "${state.recipeDetail?.ingredients?.size ?: 0} items",
                style = AppTextStyles.smallTextRegular.copy(
                    color = AppColors.gray_3,
                    fontSize = 11.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))


        // 탭바 상태에 따라 LazyColumn 교체 (재료 인지 요리 절차인지)
        when (state.recipeCategoryButtonState.buttonState) {
            RecipeDetailCategory.INGREDIENT -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(state.recipeDetail?.ingredients ?: emptyList()) { ingredient ->
                        IngredientItem(
                            imageUrl = ingredient.ingredient.image,
                            name = ingredient.ingredient.name,
                            weight = ingredient.amount
                        )
                    }
                }

            }

            RecipeDetailCategory.PROCEDURE -> {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    itemsIndexed(state.recipeDetail?.procedure ?: emptyList()) { index, procedure ->
                        ProcedureCard(
                            procedure = procedure,
                            procedureIndex = index + 1
                        )
                    }
                }

            }
        }

    }

    // Rate RecipeDialog
    if (state.isShowRateRecipeDialog) {
        RatingDialog(
            onDismissRequest = {
                onAction(RecipeDetailAction.RateRecipe(false))
            },
            send = {
                onAction(RecipeDetailAction.RateRecipe(false))
            }


        )
    }
}


@Preview(showBackground = true)
@Composable
private fun RecipeDetailScreenPreview() {
    RecipeDetailScreen(
        state = RecipeDetailState(),
        onAction = {}
    )
}