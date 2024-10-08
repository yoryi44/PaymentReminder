package com.example.paymentreminder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.paymentreminder.authentication.presentation.login.LoginScreen
import com.example.paymentreminder.authentication.presentation.signup.SignupScreen
import com.example.paymentreminder.detail.presentation.DetailScreen
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
                },
                onCreateAccount = {
                    navHostController.navigate(NavigationRoute.Signup.route)
                }
            )
        }

        //SIGNUP
        composable(NavigationRoute.Signup.route) {
            SignupScreen(
                onSignupSuccess = {
                    navHostController.popBackStack()
                    navHostController.navigate(NavigationRoute.Login.route)
                }
            )
        }

        //HOME
        composable(NavigationRoute.Home.route) {
            HomeScreen(
                onPaymentReminderDetail = {
                    navHostController.navigate(NavigationRoute.Detail.route + "?paymentReminderId=$it")
                }
            )
        }

        //DETAIL
        composable(NavigationRoute.Detail.route + "?paymentReminderId={paymentReminderId}", arguments = listOf(
            navArgument("paymentReminderId") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )) {
            DetailScreen()
            {
                navHostController.popBackStack()
            }
        }
    }
}