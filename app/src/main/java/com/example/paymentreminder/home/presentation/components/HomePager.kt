package com.example.paymentreminder.home.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.paymentreminder.authentication.presentation.login.LoginScreen
import com.example.paymentreminder.authentication.presentation.signup.SignupScreen
import com.example.paymentreminder.paymentsReminder.presentation.PaymentsReminderScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePager(
    pagerState: PagerState,
    padding: PaddingValues,
    onPaymentReminderDetail: (Int) -> Unit
) {

    //PAGER PANTALLAS
    HorizontalPager(
        count = 3,
        state = pagerState,
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) { index ->
        when (index) {
            0 -> PaymentsReminderScreen {
                onPaymentReminderDetail(it)
            }
            1 -> LoginScreen(
                onLoginSuccess = { /*TODO*/ },
                onCreateAccount = { /*TODO*/ }
            )
            2 -> SignupScreen {/*TODO*/}
        }
    }
}