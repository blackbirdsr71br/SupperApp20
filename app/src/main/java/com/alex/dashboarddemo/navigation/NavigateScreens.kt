package com.alex.dashboarddemo.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alex.dashboarddemo.presentation.screens.benefits.GSDABenefitsScreen
import com.alex.dashboarddemo.presentation.screens.credit.GSDACreditScreen
import com.alex.dashboarddemo.presentation.screens.directory.GSDADirectoryScreen
import com.alex.dashboarddemo.presentation.screens.explore.GSDAExploreScreen
import com.alex.dashboarddemo.presentation.screens.profile.GSDAProfileScreen

@Composable
fun NavigateScreens(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Explore.route,
        modifier = Modifier.padding(0.dp),
    ) {
        composable(Screen.Explore.route) {
            GSDAExploreScreen()
        }
        composable(Screen.Credit.route) {
            /*navController.navigate(Screen.Credit.route) {
                launchSingleTop = true
            }*/
            GSDACreditScreen()
        }
        composable(Screen.Directory.route) {
            /*navController.navigate(Screen.Directory.route) {
                launchSingleTop = true
            }*/
            GSDADirectoryScreen()
        }

        composable(Screen.Benefits.route) {
            /*navController.navigate(Screen.Benefits.route) {
                launchSingleTop = true
            }*/
            GSDABenefitsScreen()
        }
        composable(Screen.Profile.route) {
            /*navController.navigate(Screen.Profile.route) {
                launchSingleTop = true
            }*/
            GSDAProfileScreen()
        }
    }
}
