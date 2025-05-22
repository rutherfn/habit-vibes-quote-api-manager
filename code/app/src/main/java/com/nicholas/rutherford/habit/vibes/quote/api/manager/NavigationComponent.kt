package com.nicholas.rutherford.habit.vibes.quote.api.manager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.compose.LocalLifecycleOwner as lifecycleOwner

@Composable
fun HomeScreenTest() {
    Text(text = "Home Screen Content")
}

@Composable
fun SettingsScreenTest() {
    Column(modifier = Modifier.fillMaxSize()) {
        // This will fill the whole screen
    }
}

@Composable
fun NavigationComponent(navigator: Navigator) {
    val navController = rememberNavController()
    val lifecycleOwner = lifecycleOwner.current

    val alertInfoState by navigator.alertInfoActions.asLifecycleAwareState(
        lifecycleOwner = lifecycleOwner,
        initialState = null,
    )

    var alertInfo: AlertInfo? by remember { mutableStateOf(value = null) }

    LaunchedEffect(alertInfoState) {
        alertInfoState?.let { newAlertInfo ->
            alertInfo = newAlertInfo
        }
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { paddingValues ->
        AppNavHost(navController = navController, modifier = Modifier.padding(paddingValues).background(MaterialTheme.colorScheme.background))
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ) {
        composable(Screen.Home.route) { HomeScreenTest() }
        composable(Screen.Settings.route) { SettingsScreenTest() }
        // Add other composable destinations here
    }
}
