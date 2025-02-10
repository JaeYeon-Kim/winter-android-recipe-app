package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun MainRecipeItem(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    onBookMarkClick: (Int) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(231.dp)
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(176.dp)
                .background(
                    color = AppColors.gray_4.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(12.dp)
                )
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        ) {

            Text(
                text = recipe.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                textAlign = TextAlign.Center,
                style = AppTextStyles.mediumTextSemiBold.copy(
                    color = AppColors.gray_1,
                    fontSize = 14.sp
                )
            )

            Column(
                modifier = Modifier.align(Alignment.BottomStart)
            ) {

                Text(
                    text = "Time",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.gray_3,
                        fontSize = 11.sp
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "${recipe.time}s",
                    style = AppTextStyles.mediumTextSemiBold.copy(
                        color = AppColors.gray_1,
                        fontSize = 11.sp
                    )
                )

            }

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = AppColors.white,
                        shape = CircleShape
                    )
                    .align(Alignment.BottomEnd)
                    .clickable { onBookMarkClick(recipe.id) }
            ) {
                Image(
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.Center),
                    painter = if (recipe.isBookMarked) painterResource(R.drawable.active) else painterResource(R.drawable.inactive),
                    contentDescription = null
                )
            }

        }

        Image(painter = painterResource(R.drawable.food_1), contentDescription = null)

        RatingMark(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 30.dp),
            rate = recipe.rating,
            fontSize = 11.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainRecipeItemPreview() {
    MainRecipeItem(
        recipe = Recipe(
            category = "Indian",
            id = 1,
            name = "Classic Greek Salad",
            image = "fsdfsfsf",
            chef = "Chef John",
            time = "15 Mins",
            rating = 4.0,
            filterTime = "Newest",
            isBookMarked = false,
            video = "",
            ingredients = emptyList(),
            procedure = emptyList()
        )
    )
}