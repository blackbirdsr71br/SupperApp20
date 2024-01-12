package com.example.jetmoviesapp.presentation.navigation

sealed class Screen(val route: String) {
    object Explora : Screen(route = "Explora")
//    object Pagos: Screen( )
    object TopRated : Screen(route = "top_rated")
    object Popular : Screen(route = "popular")
    object MovieDetail : Screen(route = "movie_detail")
    object Credit : Screen(route = "Crédito")
    object Directory : Screen(route = "Directorio")
    object Benefits : Screen(route = "Beneficios")
    object Perfil : Screen(route = "Perfil")
    object LoginScreen : Screen(route = "Login")
    object Start : Screen(route = "Inicio")
}
