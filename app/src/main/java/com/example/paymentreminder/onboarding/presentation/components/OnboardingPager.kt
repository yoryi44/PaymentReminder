package com.example.paymentreminder.onboarding.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R
import com.example.paymentreminder.core.presentation.PaymentRemainderButton
import com.example.paymentreminder.core.presentation.PaymentReminderSubtitle
import com.example.paymentreminder.core.presentation.PaymentReminderTitle
import com.example.paymentreminder.onboarding.presentation.OnboardingPagerInformation
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPager(
    pages: List<OnboardingPagerInformation>,
    modifier: Modifier = Modifier,
    onFinish: () -> Unit,
) {

    val pagerState = rememberPagerState()
    val corroutineScope = rememberCoroutineScope()

    Box(modifier = modifier.fillMaxSize()) {

        //FONDO DE PANTALLA PAGER
        Image(
            painter = painterResource(id = R.mipmap.onboardin_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    alpha = 0.4f
                ),
            contentScale = ContentScale.Crop,
        )

        //PAGER
        HorizontalPager(count = pages.size, state = pagerState) { index ->
            val information = pages[index]
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(Modifier.size(1.dp))
                PaymentReminderTitle(
                    title = information.title,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.size(1.dp))
                PaymentReminderSubtitle(
                    subtitle = information.subtitle,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                //INDICADOR DE PAGER
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    if (pagerState.currentPage == pages.lastIndex) {
                        PaymentRemainderButton(
                            modifier = Modifier.fillMaxWidth(), text = "Get Starter"
                        )
                        {
                            onFinish()
                        }
                    } else {
                        TextButton(onClick = { onFinish() }) {
                            Text(text = "Skip", color = MaterialTheme.colorScheme.tertiary)
                        }
                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            activeColor = MaterialTheme.colorScheme.tertiary,
                            inactiveColor = MaterialTheme.colorScheme.primary,
                        )
                        TextButton(onClick = {
                            corroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }) {
                            Text(text = "Next", color = MaterialTheme.colorScheme.tertiary)
                        }
                    }
                }
            }
        }
    }
}