package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
fun NavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) { HomeScreenTest() }
        composable(Screen.Settings.route) { SettingsScreenTest() }
    }
}
