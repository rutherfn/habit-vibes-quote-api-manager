package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

import androidx.navigation.NavOptions

data class NavigationActionImpl(
    override val destination: String,
    override val navOptions: NavOptions = NavOptions.Builder().build()
) : NavigationAction