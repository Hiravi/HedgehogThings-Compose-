package com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.components
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.unit.Dp

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vchepyolkin.hedgehogthings.R
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.CategoriesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: Category,
    cornerRadius: Dp = 15.dp,
    onDeleteClick: () -> Unit,
    viewModel: CategoriesViewModel
) {
    val scope = rememberCoroutineScope()
    var expandedMenu by remember { mutableStateOf(false) }
    val categoryBackgroundAnimatable = remember {
        Animatable(
            Color(if (category.color != -1) category.color else viewModel.categoryColor.value)
        )
    }

    Box(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp),
            shape = RoundedCornerShape(cornerRadius),
            elevation = 5.dp,
            border = BorderStroke(2.dp, Color.Black),
        ) {
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
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


            DropdownMenu(
                expanded = expandedMenu,
                onDismissRequest = { expandedMenu = false }
            ) {
                DropdownMenuItem(onClick = {  }) {
                    Card() {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Category.categoryColors.forEach { color ->
                                val colorInt = color.toArgb()
                                Box(
                                    modifier = Modifier
                                        .size(25.dp)
                                        .shadow(15.dp, CircleShape)
                                        .clip(
                                            CircleShape
                                        )
                                        .background(color)
                                        .border(
                                            width = 2.dp,
                                            color = if (viewModel.categoryColor.value == colorInt) {
                                                Color.Black
                                            } else Color.Transparent
                                        )
                                        .clickable {
                                            scope.launch {
                                                categoryBackgroundAnimatable.animateTo(
                                                    targetValue = Color(colorInt),
                                                    animationSpec = tween(
                                                        durationMillis = 500,
                                                    )
                                                )
                                            }
                                        }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}