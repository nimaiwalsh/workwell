package com.android.workwell.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

interface Destination

interface RootDestination : Destination {
    val icon: ImageVector
    val label: String
}

@Serializable
object Home : RootDestination {
    override val icon: ImageVector = Icons.Filled.Home
    override val label: String = "Home"
}

@Serializable
object Exercises : RootDestination {
    override val icon: ImageVector = Icons.Filled.Build
    override val label: String = "Exercises"
}