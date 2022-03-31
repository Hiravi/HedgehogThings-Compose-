package com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.components
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.Dp

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vchepyolkin.hedgehogthings.R
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: Category,
    cornerRadius: Dp = 15.dp,
    onDeleteClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(150.dp),
            shape = RoundedCornerShape(cornerRadius),
            elevation = 5.dp,
            border = BorderStroke(2.dp, Color.Black)
        ) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    modifier = Modifier.size(70.dp),
                    painter = painterResource(id = R.drawable.ic_note),
                    contentDescription = "Category ${category.title}",
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Text(
                        text = category.title,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp
                        )
                    )
                }
            }
        }
    }
}