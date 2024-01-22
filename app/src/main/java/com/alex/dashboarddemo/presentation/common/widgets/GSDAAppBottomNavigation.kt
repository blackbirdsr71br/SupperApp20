package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.alex.dashboarddemo.navigation.Screen
import com.alex.dashboarddemo.ui.theme.GSVCPrimary100

@Composable
fun GSDAAppBottomNavigation(
    navController: NavController,
    currentDestination: NavDestination?,
) {
    BottomNavigation(
        modifier = Modifier.navigationBarsPadding(),
        backgroundColor = Color.White,
    ) {
        val items = listOf(
            Screen.Explore.route to Icons.Filled.Home,
            Screen.Directory.route to Icons.Filled.Search,
            Screen.Credit.route to Icons.AutoMirrored.Filled.List,
            Screen.Benefits.route to Icons.Filled.AccountBox,
            Screen.Profile.route to Icons.Filled.Person,
        )

        items.forEach { pair: Pair<String, ImageVector> ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == pair.first } == true,
                icon = { Icon(imageVector = pair.second, contentDescription = "") },
                label = { Text(text = pair.first, fontSize = 10.sp) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(pair.first) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = false
                    }
                },
                selectedContentColor = GSVCPrimary100,
                unselectedContentColor = Color.Black,
            )
        }
    }
}
