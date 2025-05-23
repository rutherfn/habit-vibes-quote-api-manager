package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.screennavigations

import com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home.HomeScreenNavigation
import com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.Navigator
import com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.Screen

class HomeScreenNavigationImpl(private val navigator: Navigator) : HomeScreenNavigation {
    override fun navigateToSettings() = navigator.navigate(destination = Screen.Settings.route)
}
