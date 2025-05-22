package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

import androidx.navigation.NavOptions

interface NavigationAction {
    val destination: String
    val navOptions: NavOptions
        get() = NavOptions.Builder().build()
}