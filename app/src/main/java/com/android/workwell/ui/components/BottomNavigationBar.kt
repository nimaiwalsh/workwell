package com.android.workwell.ui.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.android.workwell.ui.components.NavigationBarItem.Companion.buildNavigationItems
import com.android.workwell.ui.navigation.Destination
import com.android.workwell.ui.navigation.Exercises
import com.android.workwell.ui.navigation.Home

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: Destination = Home,
    onNavigate: (destination: Destination) -> Unit = {},
) {
    BottomAppBar {
        NavigationBar {
            buildNavigationItems(
                currentDestination = currentDestination,
                onNavigate = onNavigate
            ).forEach { navigationItem ->
                NavigationBarItem(
                    icon = { navigationItem.icon() },
                    label = { navigationItem.label() },
                    selected = navigationItem.selected,
                    onClick = { navigationItem.onClick() }
                )
            }
        }
    }
}

data class NavigationBarItem(
    val selected: Boolean,
    val icon: @Composable () -> Unit,
    val label: @Composable () -> Unit,
    val onClick: () -> Unit,
) {
    companion object {
        fun buildNavigationItems(
            currentDestination: Destination,
            onNavigate: (destination: Destination) -> Unit,
        ): List<NavigationBarItem> {
            return listOf(
                Home,
                Exercises,
            ).map { destination ->
                NavigationBarItem(
                    selected = currentDestination == destination,
                    label = {
                        Text(text = destination.label)
                    },
                    icon = {
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = destination.label,
                        )
                    },
                    onClick = {
                        onNavigate(destination)
                    }
                )
            }
        }
    }
}