package com.workshipflow.app.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.ui.res.painterResource

fun NavigationSuiteScope.addNavigationItems(
    currentDestination: AppDestinations,
    onDestinationSelected: (AppDestinations) -> Unit
) {
    AppDestinations.entries.forEach { destination ->
        item(
            icon = {
                Icon(
                    painter = painterResource(destination.icon),
                    contentDescription = destination.label
                )
            },
            label = { Text(destination.label) },
            selected = destination == currentDestination,
            onClick = { onDestinationSelected(destination) }
        )
    }
}