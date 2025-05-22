package com.nicholas.rutherford.habit.vibes.quote.api.manager.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightColorScheme =
    lightColorScheme(
        primary = BluePrimary,
        onPrimary = Color.White,
        secondary = Secondary,
        tertiary = Tertiary,
        background = LightScreenBackground,
        surface = LightSurface,
        onSurface = LightOnSurface,
        error = LightError
    )

val DarkColorScheme =
    darkColorScheme(
        primary = BluePrimaryDark,
        onPrimary = Color.Black,
        secondary = SecondaryDark,
        tertiary = TertiaryDark,
        background = DarkScreenBackground,
        surface = DarkSurface,
        onSurface = DarkOnSurface,
        error = DarkError
    )

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors =
        if (useDarkTheme) {
            DarkColorScheme
        } else {
            LightColorScheme
        }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
