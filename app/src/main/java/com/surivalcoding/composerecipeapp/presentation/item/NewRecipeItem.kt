package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun NewRecipeItem(
    itemIndex: Int,
    recipe: Recipe,
    onItemClick: (Int) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .width(251.dp)
            .aspectRatio(251f / 127f)
            .clickable {
                onItemClick(recipe.id)
            }
    ) {
        Box(
            modifier = Modifier
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(95.dp)
                .background(
                    color = AppColors.white,
                    shape = RoundedCornerShape(10.dp)
                )
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier.align(
                    Alignment.TopStart
                ),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    modifier = Modifier.width(140.dp),
                    text = recipe.name,
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        color = AppColors.gray_1,
                        fontSize = 14.sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                RatingBar(ratingCount = 5)
            }


            // 왼쪽 하단 프로필 이미지와 셰프 이름
            Row(
                modifier = Modifier.align(
                    Alignment.BottomStart
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AsyncImage(
                    model = R.drawable.profile4,
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                )

                Text(
                    text = "By ${recipe.chef}",
                    style = AppTextStyles.smallTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.gray_3
                    )
                )
            }

            // 오른쪽 하단 시계 이미지와 쿠킹 타임
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    painter = painterResource(R.drawable.timer),
                    contentDescription = null
                )

                Text(
                    text = "${recipe.time}s",
                    modifier = Modifier
                        .padding(vertical = 4.dp),
                    style = AppTextStyles.smallTextRegular.copy(
                        fontSize = 11.sp,
                        color = AppColors.gray_3
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 10.dp)
        ) {
            // 이미지 로드 기능
            AsyncImage(
                model = when (itemIndex) {
                    0 -> R.drawable.new_food_1
                    1 -> R.drawable.new_food_2
                    2 -> R.drawable.new_food_3
                    3 -> R.drawable.new_food_4
                    else -> R.drawable.new_food_5
                },  // drawable 이미지
                contentDescription = null,
                modifier = Modifier
                    .size(86.dp)
                    .clip(CircleShape)
                    .align(Alignment.TopEnd),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        }


    }
}

@Preview
@Composable
private fun NewRecipeItemPreview() {
    NewRecipeItem(
        itemIndex = 0,
        recipe = Recipe(
            category = "Indian",
            id = 1,
            name = "Classic Greek Salad",
            image = "fsdfsfsf",
            chef = "Chef John",
            time = "15 Min",
            rating = 4.0,
            filterTime = "Newest",
            isBookMarked = false,
            video = "",
            ingredients = emptyList(),
            procedure = emptyList()
        ),
        onItemClick = {}
    )
}