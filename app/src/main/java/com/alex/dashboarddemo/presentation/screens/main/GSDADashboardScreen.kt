package com.alex.dashboarddemo.presentation.screens.main

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.navigation.NavigateScreens
import com.alex.dashboarddemo.navigation.Screen
import com.alex.dashboarddemo.presentation.common.widgets.GSDAAppBottomNavigation
import com.alex.dashboarddemo.presentation.common.model.GSDAHeaderModel
import com.alex.dashboarddemo.presentation.common.widgets.GSSAHeader
import com.alex.dashboarddemo.ui.theme.JetDeliveryTheme
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GSDADashboardScreen(viewModel: GSDADashboardViewModel) {
    val scope = rememberCoroutineScope()

    val showRandom by remember { mutableStateOf(false) }
    val state = viewModel.uiState

    LaunchedEffect(scope) {
        state.collectLatest {
            when (it.getInfo) {
                GSDAHomeContract.DashBoardApiState.Idle -> {
                    println("Cargando")
                }

                is GSDAHomeContract.DashBoardApiState.OnNavigate -> {
                    println("Navegando a la ruta de  ${it.getInfo.route}")
                }
            }
        }
    }

    LaunchedEffect(scope) {
        viewModel.setEvent(GSDAHomeContract.Event.OnInit(showRandom))
    }

    val showBottomBar = rememberSaveable { mutableStateOf(true) }
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    JetDeliveryTheme {
        Scaffold(
            topBar = {
                val headerModelPreview =
                    GSDAHeaderModel(
                        name = "Andrea",
                        points = "200",
                        rewardsIndicator = true,
                        notificationsIndicator = true,
                        urlProfile = R.drawable.baz_logo,
                        urlNotification = R.drawable.baseline_notifications_24,
                        urlRewards = R.drawable.ic_gema,
                    )

                GSSAHeader(headerModel = headerModelPreview)
            },
            bottomBar = {
                showBottomBar.value =
                    when (currentDestination?.route?.substringBeforeLast("/")) {
                        Screen.MovieDetail.route -> false
                        else -> true
                    }
                AnimatedVisibility(
                    visible = showBottomBar.value,
                    enter = slideInVertically(initialOffsetY = { it }),
                    exit = slideOutVertically(targetOffsetY = { it }),
                ) {
                    GSDAAppBottomNavigation(
                        navController = navController,
                        currentDestination = currentDestination,
                    )
                }
            },
            backgroundColor = Color(0xFFE2E2E2),
        ) {
            NavigateScreens(
                navController = navController,
                viewModel = viewModel,
            )
        }
    }
}
