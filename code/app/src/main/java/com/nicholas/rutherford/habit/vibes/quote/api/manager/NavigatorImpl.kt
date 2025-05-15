package com.nicholas.rutherford.habit.vibes.quote.api.manager

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NavigatorImpl : Navigator {
    private val _alertActions: MutableStateFlow<AlertInfo?> = MutableStateFlow(value = null)

    override val alertInfoActions: StateFlow<AlertInfo?> = _alertActions.asStateFlow()

    override fun alert(alertActionInfo: AlertInfo) = _alertActions.update { alertActionInfo }
}
