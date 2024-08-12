package com.example.paymentreminder.home.presentation.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeBottomBar(pagerState: PagerState) {


    val corroutineScope = rememberCoroutineScope()

    //BOTTOM BAR NAVIGATION
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.blue_700),
        contentColor = Color.White,
        elevation = 10.dp
    ) {

        //OPCION HOME
        NavigationBarItem(
            alwaysShowLabel = false,
            selected = pagerState.currentPage == 0,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = colorResource(id = R.color.blue_500),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            ),
            onClick = {
                corroutineScope.launch {
                    pagerState.animateScrollToPage(0)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = stringResource(id = R.string.home)) },
        )

        //OPCION STADISTICS
        NavigationBarItem(
            alwaysShowLabel = false,
            selected = pagerState.currentPage == 1,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                selectedTextColor = Color.White,
                indicatorColor = colorResource(id = R.color.blue_500),
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White
            ),
            onClick = {
                corroutineScope.launch {
                    pagerState.animateScrollToPage(1)
                }
            },
            icon = {
                Icon(
                    painterResource(id = R.drawable.ic_statistics),
                    contentDescription = ""
                )
            }, label = { Text(text = stringResource(id = R.string.stadistics)) })

    }

}