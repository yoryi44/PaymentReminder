package com.example.paymentreminder.navigation

sealed class NavigationRoute(val route: String)
{
    object Onboarding : NavigationRoute("onboarding")
}
