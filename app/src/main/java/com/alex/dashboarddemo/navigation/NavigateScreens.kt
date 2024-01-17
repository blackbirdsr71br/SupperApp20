package com.alex.dashboarddemo.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alex.dashboarddemo.presentation.components.ModalBottomSheetD
import com.alex.dashboarddemo.presentation.components.ShowError
import com.alex.dashboarddemo.presentation.components.ShowLoading
import com.alex.dashboarddemo.presentation.dashboard.GSSMAProductGenericScreen
import com.alex.dashboarddemo.presentation.dashboard.categories
import com.alex.dashboarddemo.presentation.dashboard.collapsingtoolbarincompose.ui.composables.standAloneStore.GSSMAStandAloneStoreScreen
import com.alex.dashboarddemo.presentation.dashboard.products
import com.alex.dashboarddemo.presentation.dashboard.standAloneStore
import com.alex.dashboarddemo.presentation.screens.main.GSDADashboardScreen
import com.alex.dashboarddemo.presentation.screens.main.GSDADashboardViewModel

@Composable
fun NavigateScreens(
    navController: NavHostController,
    viewModel: GSDADashboardViewModel,
) {
    val data = viewModel.dashboardItems.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Screen.Start.route,
        modifier = Modifier.padding(0.dp),
    ) {
        composable(Screen.LoginScreen.route) {}

        composable(Screen.Start.route) {
            when {
                data.isLoading -> {
                    ShowLoading()
                }

                data.items != null -> {
                    GSDADashboardScreen(dashboard = data.items)
                }

                !data.errorMessage.isNullOrEmpty() -> {
                    ShowError(
                        message = data.errorMessage,
                        onRetry = {
                            // viewModel.loadData(showRandom)
                        },
                    )
                }
            }
        }
        composable(Screen.Explore.route) {
            val dataUI = viewModel.uiState

            when {
                data.isLoading -> {
                    ShowLoading()
                }

                data.items != null -> {
                    GSDADashboardScreen(dashboard = data.items)
                }

                !data.errorMessage.isNullOrEmpty() -> {
                    ShowError(
                        message = data.errorMessage,
                        onRetry = {
                            // viewModel.loadData(showRandom)
                        },
                    )
                }
            }
        }
        composable(Screen.Directory.route) {
            GSSMAProductGenericScreen(
                productList = products,
                txtTitle = "Ofertas",
                txtSubTitle = "",
                onBackClick = {},
                onFilterClick = {},
            )
        }
        composable(Screen.Popular.route) {
        }
        composable(Screen.Credit.route) {
            val context = LocalContext.current
            GSSMAStandAloneStoreScreen(
                standAloneGrid = standAloneStore,
                standAloneCategories = categories,
                onBackButtonClicked = {
                    Toast.makeText(context, "Back button clicked!", Toast.LENGTH_SHORT).show()
                },
                onSearchButtonClicked = {
                    Toast.makeText(context, "Search button clicked!", Toast.LENGTH_SHORT).show()
                },
                onShoppingCartButtonClicked = {
                    Toast.makeText(context, "Cart button clicked!", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.fillMaxSize(),
            )
        }
        composable(Screen.Benefits.route) {
            ModalBottomSheetD()
        }
        composable(Screen.Profile.route) {
        }
    }
}
