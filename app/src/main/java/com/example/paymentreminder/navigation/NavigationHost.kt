package com.example.paymentreminder.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.paymentreminder.authentication.presentation.login.LoginScreen
import com.example.paymentreminder.authentication.presentation.signup.SignupScreen
import com.example.paymentreminder.detail.presentation.DetailScreen
import com.example.paymentreminder.home.presentation.HomeScreen
import com.example.paymentreminder.onboarding.presentation.OnboardingScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: Any,
)
{
    NavHost(navController = navHostController, startDestination = startDestination) {

        //ONBOARDING
        composable<Onboarding> {
            OnboardingScreen(
                onFinish = {
                    navHostController.popBackStack()
                    navHostController.navigate(Login)
                }
            )
        }

        //LOGIN
        composable<Login> {
            LoginScreen(
                onLoginSuccess = {
                    navHostController.popBackStack()
                    navHostController.navigate(Home)
                },
                onCreateAccount = {
                    navHostController.navigate(Signup)
                }
            )
        }

        //SIGNUP
        composable<Signup> {
            SignupScreen(
                onSignupSuccess = {
                    navHostController.popBackStack()
                    navHostController.navigate(Login)
                }
            )
        }

        //HOME
        composable<Home> {
            HomeScreen(
                onPaymentReminderDetail = {
                    navHostController.navigate(Detail(paymentReminderId = it))
                }
            )
        }

        //DETAIL
        composable<Detail> {
            val detail = it.toRoute<Detail>()
            DetailScreen(
                paymentReminderId = detail.paymentReminderId,
            )
            {
                navHostController.popBackStack()
            }
        }
    }
}