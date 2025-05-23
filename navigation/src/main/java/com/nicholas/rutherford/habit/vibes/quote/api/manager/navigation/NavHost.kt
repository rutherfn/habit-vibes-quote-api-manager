package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home.HomeScreen
import com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home.HomeScreenParams
import com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home.HomeScreenViewModel

@Composable
fun HomeScreenTest() {
    Text(text = "Home Screen Content")
}

@Composable
fun SettingsScreenTest() {
    Column(modifier = Modifier.fillMaxSize()) {
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    homeScreenViewModel: HomeScreenViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                params = HomeScreenParams(
                    items = homeScreenViewModel.homeStateFlow.collectAsState().value.items,
                    onItemClick = { item -> homeScreenViewModel.onItemClicked() }
                )
            )
        }
        composable(Screen.Settings.route) { SettingsScreenTest() }
    }
}
