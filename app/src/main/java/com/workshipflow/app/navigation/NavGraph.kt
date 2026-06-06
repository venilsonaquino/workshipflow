package com.workshipflow.app.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.workshipflow.app.features.auth.LoginScreen
import com.workshipflow.app.features.favorites.FavoritesScreen
import com.workshipflow.app.features.home.HomeScreen
import com.workshipflow.app.features.schedule.ScheduleScreen

@Composable
fun NavGraph(
    currentDestination: AppDestinations,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier.fillMaxSize()) {
        when (currentDestination) {
            AppDestinations.HOME -> HomeScreen()
            AppDestinations.SCHEDULE -> ScheduleScreen()
            AppDestinations.FAVORITES -> FavoritesScreen()
            AppDestinations.PROFILE -> LoginScreen()
        }
    }
}