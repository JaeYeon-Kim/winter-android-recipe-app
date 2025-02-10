package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    isDetail: Boolean = false,      // 레시피 상세 화면일 경우 이름 영역 visible 처리
    onItemClick: (Recipe) -> Unit = {},     // 리스트 내 아이템 클릭 처리
    onDeleteBookMark: (Int) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .aspectRatio(2f)
            .clickable { onItemClick(recipe) },
        contentAlignment = Alignment.TopStart,
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(recipe.image)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(R.drawable.ic_launcher_foreground)
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {

            if (!isDetail) {
                Column(
                    modifier = Modifier.align(Alignment.BottomStart)
                ) {
                    Text(
                        text = recipe.name,
                        modifier = Modifier.width(200.dp),
                        maxLines = 2,
                        style = AppTextStyles.smallTextBold.copy(
                            fontSize = 14.sp, color = AppColors.white
                        )
                    )

                    Text(
                        text = "By ${recipe.chef}",
                        style = AppTextStyles.smallTextRegular.copy(
                            fontSize = 8.sp, color = AppColors.white
                        )
                    )
                }
            }

            Row(
                modifier = Modifier.align(Alignment.BottomEnd),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(painter = painterResource(R.drawable.timer), contentDescription = null)

                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = recipe.time,
                    style = AppTextStyles.smallTextRegular.copy(color = AppColors.gray_4)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Box(
                    Modifier
                        .size(24.dp)
                        .background(color = AppColors.white, shape = RoundedCornerShape(50.dp))
                        .clickable { onDeleteBookMark(recipe.id) }
                ) {
                    Image(
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.Center)
                            .padding(1.dp),
                        painter = painterResource(R.drawable.active), contentDescription = null
                    )
                }
            }
            RatingMark(
                modifier = Modifier.align(Alignment.TopEnd),
                rate = recipe.rating,
                fontSize = 8.sp
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
private fun RecipeCardPreview() {
    RecipeCard(
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
        isDetail = false
    )
}