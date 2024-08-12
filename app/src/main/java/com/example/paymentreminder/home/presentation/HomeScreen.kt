package com.example.paymentreminder.home.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.paymentreminder.home.presentation.components.HomeBottomBar
import com.example.paymentreminder.home.presentation.components.HomePager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {

    val pagerState = rememberPagerState()

    Scaffold(

        //BARRA DE NAVEGACIÓN INFERIOR
        bottomBar = {
            HomeBottomBar(pagerState)
        }
    ) { padding ->

        //VIEW PAGER
        HomePager(pagerState, padding)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}