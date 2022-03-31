package com.vchepyolkin.hedgehogthings.util

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object CategoriesScreen: Screen("category_screen")
    object AddEditCategoryScreen: Screen("add_edit_category_screen")
}
