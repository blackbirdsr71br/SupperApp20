package com.alex.dashboarddemo.navigation

sealed class Screen(val route: String) {
    object Explore : Screen(route = "Explora")
    object Credit : Screen(route = "Crédito")
    object Directory : Screen(route = "Directorio")
    object Benefits : Screen(route = "Beneficios")
    object Profile : Screen(route = "Perfil")
}
