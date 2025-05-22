package com.nicholas.rutherford.habit.vibes.quote.api.manager

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import java.util.Locale

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(Screen.Home, Screen.Settings)
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Settings)

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = selectedItem == index

            NavigationBarItem(
                icon = { Icon(
                    icons[index],
                    contentDescription = item.route,
                    tint = if (isSelected) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.secondary
                    }
                ) },
                label = {
                    Text(
                        text = item.route.replaceFirstChar {
                            if (it.isLowerCase()) {
                                it.titlecase(
                                    Locale.ROOT,
                                )
                            } else {
                                it.toString()
                            }
                        },
                        color = if (isSelected) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.secondary
                        }
                    )
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    val navController = rememberNavController()

    BottomNavigationBar(navController = navController)
}
