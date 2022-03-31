package com.vchepyolkin.hedgehogthings
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.CategoriesScreen
import com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.add_edit_category.AddEditCategoryScreen
import com.vchepyolkin.hedgehogthings.home.HomeScreen
import com.vchepyolkin.hedgehogthings.ui.theme.HedgehogThingsTheme
import com.vchepyolkin.hedgehogthings.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HedgehogThingsTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CategoriesScreen.route
                        ) {

                            CategoriesScreen(navController = navController)
                        }

                        composable(
                            route = Screen.AddEditCategoryScreen.route +
                                    "?categoryId={categoryId}&categoryColor={categoryColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "categoryId",
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },

                                navArgument(
                                    name = "categoryColor",
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            ),
                        ) {
                            val color = it.arguments?.getInt("categoryColor") ?: -1
                            AddEditCategoryScreen(
                                navController = navController,
                                categoryColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Show() {

    HedgehogThingsTheme {

    }
}



