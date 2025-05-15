package com.nicholas.rutherford.habit.vibes.quote.api.manager

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object Settings : Screen("settings")
}
