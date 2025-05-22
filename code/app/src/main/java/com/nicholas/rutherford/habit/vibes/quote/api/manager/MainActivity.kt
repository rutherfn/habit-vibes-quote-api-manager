package com.nicholas.rutherford.habit.vibes.quote.api.manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nicholas.rutherford.habit.vibes.quote.api.manager.compose.ui.theme.AppTheme
import com.nicholas.rutherford.habit.vibes.quote.api.manager.navigation.NavigationComponent
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                NavigationComponent(
                    navigator = get(),
                    homeScreenViewModel = getViewModel()
                )
            }
        }
    }
}
