package com.alex.dashboarddemo.ui.navigation

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
import com.alex.dashboarddemo.ModalBottomSheetD
import com.alex.dashboarddemo.components.ShowError
import com.alex.dashboarddemo.components.ShowLoading
import com.alex.dashboarddemo.data.Result
import com.alex.dashboarddemo.ui.dashboard.GSSMAProductGenericScreen
import com.alex.dashboarddemo.ui.dashboard.ShowDashboard
import com.alex.dashboarddemo.ui.dashboard.categories
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.composables.standAloneStore.GSSMAStandAloneStoreScreen
import com.alex.dashboarddemo.ui.dashboard.products
import com.alex.dashboarddemo.ui.dashboard.standAloneStore
import com.alex.dashboarddemo.ui.main.MainViewModel
import com.example.jetmoviesapp.presentation.navigation.Screen

@Composable
fun NavigateScreens(
    navController: NavHostController,
    viewModel: MainViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route,
        modifier = Modifier.padding(0.dp),
    ) {
        composable(Screen.LoginScreen.route) {
        }

        composable(Screen.Start.route) {
            when (val data = viewModel.dashboardItems.collectAsState().value) {
                is Result.Loading -> {
                    ShowLoading()
                }

                is Result.Success -> {
                    ShowDashboard(
                        data = data.data ?: emptyList(),
                    )
                }

                is Result.Failure -> {
                    ShowError(
                        message = data.error.message ?: "",
                        onRetry = {
                            // viewModel.loadData(showRandom)
                        },
                    )
                }
            }
        }
        composable(Screen.Explora.route) {
            val data = viewModel.uiState

            when (val data = viewModel.dashboardItems.collectAsState().value) {
                is Result.Loading -> {
                    ShowLoading()
                }

                is Result.Success -> {
                    ShowDashboard(
                        data = data.data ?: emptyList(),
                    )
                }

                is Result.Failure -> {
                    ShowError(
                        message = data.error.message ?: "",
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
        composable(Screen.Perfil.route) {
        }
    }
}
