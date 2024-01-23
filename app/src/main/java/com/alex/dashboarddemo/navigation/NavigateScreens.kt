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
import com.alex.dashboarddemo.presentation.common.components.GSDAShowError
import com.alex.dashboarddemo.presentation.common.components.GSDAShowLoading
import com.alex.dashboarddemo.presentation.screens.GSDAProductGenericScreen
import com.alex.dashboarddemo.data.mockdata.categories
import com.alex.dashboarddemo.presentation.screens.GSDAStandAloneStoreScreen
import com.alex.dashboarddemo.data.mockdata.products
import com.alex.dashboarddemo.data.mockdata.standAloneStore
import com.alex.dashboarddemo.presentation.screens.main.widget.GSDADashboardScreen
import com.alex.dashboarddemo.presentation.screens.main.GSDADashboardViewModel

@Composable
fun NavigateScreens(
    navController: NavHostController,
    viewModel: GSDADashboardViewModel,
) {
    val data = viewModel.dashboardItems.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Screen.Explore.route,
        modifier = Modifier.padding(0.dp),
    ) {
        composable(Screen.LoginScreen.route) {}

        composable(Screen.Explore.route) {
            when {
                data.isLoading -> {
                    GSDAShowLoading()
                }

                data.items != null -> {
                    GSDADashboardScreen(dashboard = data.items)
                }

                !data.errorMessage.isNullOrEmpty() -> {
                    GSDAShowError(
                        message = data.errorMessage,
                        onRetry = {
                            // viewModel.loadData(showRandom)
                        },
                    )
                }
            }
        }
        composable(Screen.Directory.route) {
            GSDAProductGenericScreen(
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
            GSDAStandAloneStoreScreen(
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
        composable(Screen.Benefits.route) {}
        composable(Screen.Profile.route) {}
    }
}
