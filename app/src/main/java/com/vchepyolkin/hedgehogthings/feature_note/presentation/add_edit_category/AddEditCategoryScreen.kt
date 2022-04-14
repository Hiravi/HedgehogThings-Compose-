package com.vchepyolkin.hedgehogthings.feature_note.presentation.add_edit_category

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import com.vchepyolkin.hedgehogthings.feature_note.presentation.add_edit_category.components.TransparentHintTextField
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun AddEditCategoryScreen(
    navController: NavController,
    categoryColor: Int,
    viewModel: AddEditViewModel = hiltViewModel(),
) {
    val titleState = viewModel.categoryTitle.value

    val scaffoldState = rememberScaffoldState()

    val categoryBackgroundAnimatable = remember {
        Animatable(
            Color(if (categoryColor != -1) categoryColor else viewModel.categoryColor.value)
        )
    }
    val scope = rememberCoroutineScope()
    
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is AddEditViewModel.UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is AddEditViewModel.UiEvent.SaveCategory -> {
                    navController.navigateUp()
                }
            }

        }
    }
    
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.onEvent(AddEditCategoryEvent.SaveCategory)
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Save, contentDescription = "Save note button")
            }
        },
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(categoryBackgroundAnimatable.value)
                .padding(16.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Category.categoryColors.forEach { color ->
                    val colorInt = color.toArgb()
                    
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .shadow(15.dp, CircleShape)
                            .clip(CircleShape)
                            .background(color)
                            .border(
                                width = 3.dp,
                                color = if (viewModel.categoryColor.value == colorInt) {
                                    Color.Black
                                } else Color.Transparent,
                                shape = CircleShape
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
            
            Spacer(modifier = Modifier.width(16.dp))
            
            TransparentHintTextField(
                text = titleState.text,
                hint = titleState.hint,
                onValueChange = {
                    viewModel.onEvent(AddEditCategoryEvent.EnteredTitle(it))
                },
                onFocusChange = {
                    viewModel.onEvent(AddEditCategoryEvent.ChangeTitleFocus(it))
                },
                isHintVisible = titleState.isHintVisible,
                singleLine = true,
                textStyle = MaterialTheme.typography.h5,
            )
        }

    }
}