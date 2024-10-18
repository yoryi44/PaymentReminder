package com.example.paymentreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.paymentreminder.navigation.Home
import com.example.paymentreminder.navigation.Login
import com.example.paymentreminder.navigation.NavigationHost
import com.example.paymentreminder.navigation.Onboarding
import com.example.paymentreminder.ui.theme.PaymentReminderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            mainViewModel.isLoading
        }

        enableEdgeToEdge()
        setContent {
            PaymentReminderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding))
                    {
                        val navController = rememberNavController()
                        NavigationHost(
                            navHostController = navController,
                            startDestination = getDestination(),
                        )
                    }
                }
            }
        }
    }

    private fun getDestination(): Any {

        if(mainViewModel.isLoggedIn)
        {
            return Home
        }

        if(mainViewModel.hasSeenOnboarding)
        {
            return Login
        }

        return Onboarding
    }
}
