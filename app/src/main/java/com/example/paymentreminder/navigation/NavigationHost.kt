package com.example.paymentreminder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.paymentreminder.authentication.presentation.login.LoginScreen
import com.example.paymentreminder.home.presentation.HomeScreen
import com.example.paymentreminder.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: NavigationRoute,
)
{
    NavHost(navController = navHostController, startDestination = startDestination.route) {

        //ONBOARDING
        composable(NavigationRoute.Onboarding.route) {
            OnboardingScreen(
                onFinish = {
                    navHostController.popBackStack()
                    navHostController.navigate(NavigationRoute.Login.route)
                }
            )
        }

        //LOGIN
        composable(NavigationRoute.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navHostController.popBackStack()
                    navHostController.navigate(NavigationRoute.Home.route)
                }
            )
        }

        //LOGIN
        composable(NavigationRoute.Home.route) {
            HomeScreen()
        }
    }
}