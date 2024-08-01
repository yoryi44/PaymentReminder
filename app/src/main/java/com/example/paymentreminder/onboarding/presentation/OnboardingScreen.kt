package com.example.paymentreminder.onboarding.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.paymentreminder.R
import com.example.paymentreminder.onboarding.presentation.components.OnboardingPager

@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {

    var pagerlist = listOf(
        OnboardingPagerInformation(
            stringResource(id = R.string.welcome),
            stringResource(id = R.string.welcome_subtitle),
            R.drawable.onboarding_background
        ),
        OnboardingPagerInformation(
            stringResource(id = R.string.pager_title_1),
            stringResource(id = R.string.pager_subtitle_1),
            R.drawable.onboarding_background
        ),
        OnboardingPagerInformation(
            stringResource(id = R.string.pager_title_2),
            stringResource(id = R.string.pager_subtitle_2),
            R.drawable.onboarding_background
        ),
        OnboardingPagerInformation(
            stringResource(id = R.string.pager_title_3),
            stringResource(id = R.string.pager_subtitle_3),
            R.drawable.onboarding_background
        )
    )

    OnboardingPager(pages = pagerlist, onFinish = onFinish)
}