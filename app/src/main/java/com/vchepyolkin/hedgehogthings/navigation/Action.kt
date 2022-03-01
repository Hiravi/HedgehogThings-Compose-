package com.vchepyolkin.hedgehogthings.navigation

import androidx.navigation.NavHostController

class Action(navController: NavHostController) {
    val home: () -> Unit = { navController.navigate(HOME) }
    val diary: () -> Unit = { navController.navigate(DIARY) }
    val album: () -> Unit = { navController.navigate(ALBUM) }
    val back: () -> Unit = { navController.popBackStack() }

    companion object Destinations {
        const val HOME = "Home"
        const val DIARY = "Diary"
        const val ALBUM = "Album"
    }
}

