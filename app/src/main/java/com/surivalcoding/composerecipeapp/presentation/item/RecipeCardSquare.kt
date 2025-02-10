package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.SearchRecipeAction
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun RecipeCardSquare(
    recipe: Recipe,
    onAction: (SearchRecipeAction) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .size(150.dp)
            .clickable {
                onAction(SearchRecipeAction.SearchRecipeDetail(recipe))
            },
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

            Row(
                modifier = Modifier
                    .background(
                        color = AppColors.secondary20,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .align(Alignment.TopEnd)
                    .padding(horizontal = 7.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.star),
                    modifier = Modifier
                        .size(8.dp)
                        .offset(y = ((-0.5).dp)),
                    contentDescription = null,
                )

                Text(
                    text = recipe.rating.toString(),
                    style = AppTextStyles.smallTextRegular.copy(
                        fontSize = 8.sp, color = AppColors.black
                    ),
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun RecipeCardSquarePreview() {
    RecipeCardSquare(
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
        onAction = {}
    )
}