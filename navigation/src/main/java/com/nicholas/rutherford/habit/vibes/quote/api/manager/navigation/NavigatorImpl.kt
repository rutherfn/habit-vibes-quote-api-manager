package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

import androidx.navigation.NavOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NavigatorImpl : Navigator {
    private val _alertActions: MutableStateFlow<AlertInfo?> = MutableStateFlow(value = null)
    private val _navigationAction: MutableStateFlow<NavigationAction?> = MutableStateFlow(value = null)

    override val alertInfoActions: StateFlow<AlertInfo?> = _alertActions.asStateFlow()
    override val navAction: StateFlow<NavigationAction?> = _navigationAction.asStateFlow()

    override fun alert(alertActionInfo: AlertInfo) = _alertActions.update { alertActionInfo }
    override fun navigate(destination: String, navOptions: NavOptions) = _navigationAction.update { NavigationActionImpl(destination = destination, navOptions = navOptions) }
}
