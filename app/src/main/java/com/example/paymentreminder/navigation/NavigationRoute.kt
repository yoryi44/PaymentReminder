package com.example.paymentreminder.navigation

sealed class NavigationRoute(val route: String)
{
    data object Onboarding : NavigationRoute("onboarding")
    data object Login : NavigationRoute("login")
    data object Signup : NavigationRoute("signup")
    data object Home : NavigationRoute("home")
    data object Detail : NavigationRoute("detail")
}
