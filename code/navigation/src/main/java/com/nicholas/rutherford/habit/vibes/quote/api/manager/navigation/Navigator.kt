package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

import kotlinx.coroutines.flow.StateFlow

interface Navigator {
    val alertInfoActions: StateFlow<AlertInfo?>

    fun alert(alertActionInfo: AlertInfo)
}
