package com.example.paymentreminder.home.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.paymentreminder.paymentsReminder.presentation.PaymentsReminderScreen
import com.example.paymentreminder.statistics.presentation.StatisticsScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePager(
    pagerState: PagerState,
    padding: PaddingValues,
    onPaymentReminderDetail: (String) -> Unit
) {

    //PAGER PANTALLAS
    HorizontalPager(
        count = 2,
        state = pagerState,
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) { index ->
        when (index) {
            0 -> PaymentsReminderScreen {
                onPaymentReminderDetail(it)
            }
            1 -> StatisticsScreen()
        }
    }
}