package com.example.paymentreminder.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.paymentreminder.authentication.presentation.login.LoginScreen
import com.example.paymentreminder.paymentList.presentation.PaymentListScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePager(
    pagerState: PagerState,
    padding: PaddingValues
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
            0 -> PaymentListScreen()
            1 -> LoginScreen(){}
            2 -> PaymentListScreen()
        }
    }
}