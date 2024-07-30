package com.example.paymentreminder.onboarding.presentation

import androidx.compose.runtime.Composable
import com.example.paymentreminder.R
import com.example.paymentreminder.onboarding.presentation.components.OnboardingPager

@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {

    var pagerlist = listOf(
        OnboardingPagerInformation(
            "Bienvenido",
            "Te damos la bienvenida a PaymentReminder",
            R.drawable.onboarding_background
        ),
        OnboardingPagerInformation(
            "Esta app ayuda a tu bolsillo",
            "Te ayudamos a tener en cuenta todos tus pagos mensuales",
            R.drawable.onboarding_background
        ),
        OnboardingPagerInformation(
            "Que no se te pase una!",
            "Qué tus obligaciones sean lo primero y no se te pierda de vista!",
            R.drawable.onboarding_background
        )
    )

    OnboardingPager(pages = pagerlist, onFinish = onFinish)
}