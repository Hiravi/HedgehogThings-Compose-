package com.vchepyolkin.hedgehogthings.state

import androidx.compose.material.lightColors

sealed class Screen {
    object Home : Screen()
    object Album : Screen()
    object Diary : Screen()
}

object AppState {
    var currentScreen: Screen = Screen.Home
    var theme = lightColors()
}

fun navigateTo(destination: Screen) {
    AppState.currentScreen = destination
}

fun isLightTheme() : Boolean {
    return AppState.theme.isLight
}