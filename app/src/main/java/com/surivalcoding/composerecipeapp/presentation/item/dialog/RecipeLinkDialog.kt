package com.surivalcoding.composerecipeapp.presentation.item.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.button.FreeButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles
import com.surivalcoding.composerecipeapp.util.CommonUtils.generateRecipeDeepLink

@Composable
fun RecipeLinkDialog(
    recipeId: Int,
    onCopyLink: (String) -> Unit = {},
    onDismiss: () -> Unit = {},
) {

    Dialog(onDismissRequest = { onDismiss() }) {
        Card(
            modifier = Modifier.width(310.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = AppColors.white
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 15.dp)
            ) {
                // 닫기 버튼
                Icon(
                    modifier = Modifier.align(Alignment.TopEnd),
                    painter = painterResource(id = R.drawable.cancel),
                    contentDescription = null,
                    tint = AppColors.gray_1
                )


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Recipe Link",
                        style = AppTextStyles.mediumTextSemiBold.copy(
                            color = AppColors.black,
                            fontSize = 20.sp
                        )
                    )

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Copy recipe link and share your recipe link with friends and family.",
                        style = AppTextStyles.smallTextRegular.copy(
                            color = AppColors.gray_2,
                            fontSize = 11.sp
                        )
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = AppColors.gray_4, shape = RoundedCornerShape(9.dp))
                            .padding(start = 14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = generateRecipeDeepLink(recipeId),
                            style = AppTextStyles.smallTextMedium.copy(
                                color = AppColors.label_color,
                                fontSize = 11.sp
                            )
                        )

                        // Copy Link 버튼 , 추후 Selected 수정 필요
                        FreeButton(text = "Copy Link", isSelected = false, onClick = {
                            onCopyLink(generateRecipeDeepLink(recipeId))
                        })
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecipeDialogPreview() {
    RecipeLinkDialog(
        recipeId = 1,
        onDismiss = {}
    )
}