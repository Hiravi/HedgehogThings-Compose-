package com.vchepyolkin.hedgehogthings.feature_note.presentation.categories

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util.CategoriesEvent
import com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.components.CategoryItem
import com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.components.OrderSection
import com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.components.TopBar
import com.vchepyolkin.hedgehogthings.util.Screen
import kotlinx.coroutines.launch

@Composable
@ExperimentalFoundationApi
fun CategoriesScreen(
    navController: NavController,
    viewModel: CategoriesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    TODO()
                },
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add category button"
                )
            }
        },
        topBar = {
            TopBar(
                title = "Категории",
                onBack = { navController.navigateUp() }
            )
        },
        scaffoldState = scaffoldState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                IconButton(
                    onClick = {
                        viewModel.onEvent(CategoriesEvent.ToggleOrderSection)
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Sort,
                        contentDescription = "Sort"
                    )
                }
            }

            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically(),
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    categoryOrder = state.categoryOrder,
                    onOrderChange = {
                        viewModel.onEvent(CategoriesEvent.Order(it))
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(cells = GridCells.Fixed(2)) {
                items(state.categories) { category ->
                    CategoryItem(
                        category = category,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(
                                    Screen.AddEditCategoryScreen.route +
                                            "?categoryId=${category.id}&categoryColor=${category.color}"
                                )
                            },
                        onDeleteClick = {
                            viewModel.onEvent(CategoriesEvent.DeleteCategory(category))
                            scope.launch {
                                val result = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Note deleted",
                                    actionLabel = "Undo"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.onEvent(CategoriesEvent.RestoreCategory)
                                }
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}



