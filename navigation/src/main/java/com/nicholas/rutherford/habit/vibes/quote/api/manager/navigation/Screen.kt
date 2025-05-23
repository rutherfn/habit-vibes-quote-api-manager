package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object Settings : Screen("settings")
}
