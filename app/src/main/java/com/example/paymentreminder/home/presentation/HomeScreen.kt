package com.example.paymentreminder.home.presentation

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.paymentreminder.R
import com.example.paymentreminder.home.presentation.components.HomeBottomBar
import com.example.paymentreminder.home.presentation.components.HomePager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    onPaymentReminderDetail: (String) -> Unit
) {

    val pagerState = rememberPagerState()

    Scaffold(

        //BARRA DE NAVEGACIÓN INFERIOR
        bottomBar = {
            HomeBottomBar(pagerState)
        },

        //BOTON PARA CREAR NUEVO RECORADTORIO
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onPaymentReminderDetail("") },
                containerColor = colorResource(id = R.color.warning),
                shape = CircleShape
            ) {
                Icon(
                    Icons.Outlined.Add,
                    contentDescription = "add new payment reminder"
                )
            }
        }

    ) { padding ->

        //VIEW PAGER
        HomePager(pagerState, padding) {
            onPaymentReminderDetail(it)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen {
    }
}