package com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home

data class HomeScreenParams(
    val items: Map<String, List<HomeItem>>,
    val onItemClick: (String) -> Unit
)