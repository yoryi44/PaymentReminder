package com.example.paymentreminder.navigation

sealed class NavigationRoute(val route: String)
{
    object Onboarding : NavigationRoute("onboarding")
    object Login : NavigationRoute("login")
    object Home : NavigationRoute("home")
}
