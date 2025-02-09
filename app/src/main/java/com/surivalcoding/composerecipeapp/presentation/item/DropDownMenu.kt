package com.surivalcoding.composerecipeapp.presentation.item

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun DropDownMenuWithDetails(
    isExpanded: Boolean,
    onDismissRequest: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onRateRecipeClick: () -> Unit = {},
    onReviewClick: () -> Unit = {},
    onUnsaveClick: () -> Unit = {},
) {

    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = { onDismissRequest() },
        containerColor = AppColors.white,
        shape = RoundedCornerShape(8.dp)
    ) {
        // First section
        DropdownMenuItem(
            text = {
                Text(
                    text = "share",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.label_color,
                        fontSize = 14.sp
                    )
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.dropdown_1), contentDescription = null,
                    tint = AppColors.label_color
                )
            },
            onClick = {
                onShareClick()
            },
            contentPadding = PaddingValues(horizontal = 18.dp),
            modifier = Modifier.height(40.dp)
        )

        // First section
        DropdownMenuItem(
            text = {
                Text(
                    text = "Rate Recipe",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.label_color,
                        fontSize = 14.sp
                    )
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.dropdown_2), contentDescription = null,
                    tint = AppColors.label_color
                )
            },
            onClick = {
                onRateRecipeClick()
            },
            contentPadding = PaddingValues(horizontal = 18.dp),
            modifier = Modifier.height(40.dp)
        )

        // First section
        DropdownMenuItem(
            text = {
                Text(
                    text = "Review",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.label_color,
                        fontSize = 14.sp
                    )
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.dropdown_3), contentDescription = null,
                    tint = AppColors.label_color
                )
            },
            onClick = {},
            contentPadding = PaddingValues(horizontal = 18.dp),
            modifier = Modifier.height(40.dp)
        )

        // First section
        DropdownMenuItem(
            text = {
                Text(
                    text = "Unsave",
                    style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.label_color,
                        fontSize = 14.sp
                    )
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.dropdown_test), contentDescription = null,
                    tint = AppColors.label_color
                )
            },
            onClick = { },
            contentPadding = PaddingValues(horizontal = 18.dp),
            modifier = Modifier.height(40.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun DropDownMenuWithDetailsPreview() {
    ComposeRecipeAppTheme {
        DropDownMenuWithDetails(isExpanded = true)

    }
}