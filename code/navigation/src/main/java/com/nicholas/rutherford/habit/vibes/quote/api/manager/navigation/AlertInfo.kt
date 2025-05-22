package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

data class AlertInfo(
    val title: String,
    val onDismissClicked: (() -> Unit)? = null,
    val description: String? = null
)
