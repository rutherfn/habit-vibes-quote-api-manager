package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

import androidx.navigation.NavOptions
import kotlinx.coroutines.flow.StateFlow

interface Navigator {
    val alertInfoActions: StateFlow<AlertInfo?>
    val navAction: StateFlow<NavigationAction?>

    fun alert(alertActionInfo: AlertInfo)
    fun navigate(destination: String, navOptions: NavOptions = NavOptions.Builder().build())
}
