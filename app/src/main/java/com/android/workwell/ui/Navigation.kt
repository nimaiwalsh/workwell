package com.android.workwell.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.android.workwell.ui.navigation.Exercises
import com.android.workwell.ui.navigation.Home
import com.android.workwell.ui.navigation.MainNavGraph

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MainNavGraph
    ) {
        mainNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
) {
    navigation<MainNavGraph>(
        startDestination = Home,
    ) {
        composable<Home> {
            Text(
                text = "Hello nob!",
            )
        }

        composable<Exercises> {
            Text(
                text = "Escercise",
            )
        }
    }
}