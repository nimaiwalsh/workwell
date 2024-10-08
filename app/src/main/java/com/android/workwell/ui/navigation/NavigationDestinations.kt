package com.android.workwell.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

interface NavGraph

@Serializable
object MainNavGraph : NavGraph

interface Destination

interface RootDestination : Destination {
    val icon: ImageVector
    val label: String
}

fun RootDestination.route() = this::class.qualifiedName.toString()

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