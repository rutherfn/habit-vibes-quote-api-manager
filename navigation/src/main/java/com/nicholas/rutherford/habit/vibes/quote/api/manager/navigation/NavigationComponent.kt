package com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.nicholas.rutherford.habit.vibes.quote.api.manager.feature.home.HomeScreenViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner as lifecycleOwner

@Composable
fun NavigationComponent(
    navigator: Navigator,
    homeScreenViewModel: HomeScreenViewModel
) {
    val navController = rememberNavController()
    val lifecycleOwner = lifecycleOwner.current

    val alertInfoState by navigator.alertInfoActions.asLifecycleAwareState(
        lifecycleOwner = lifecycleOwner,
        initialState = null
    )
    val navigatorState by navigator.navAction.asLifecycleAwareState(
        lifecycleOwner = lifecycleOwner,
        initialState = null
    )

    var alertInfo: AlertInfo? by remember { mutableStateOf(value = null) }

    LaunchedEffect(alertInfoState) {
        alertInfoState?.let { newAlertInfo ->
            alertInfo = newAlertInfo
        }
    }

    LaunchedEffect(navigatorState) {
        navigatorState?.let { state ->
            navController.navigate(
                route = state.destination,
                navOptions = state.navOptions
            )
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(paddingValues).background(MaterialTheme.colorScheme.background),
            homeScreenViewModel = homeScreenViewModel
        )
    }
}
