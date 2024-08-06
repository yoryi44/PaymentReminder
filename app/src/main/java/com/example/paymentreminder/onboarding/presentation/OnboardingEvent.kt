package com.example.paymentreminder.onboarding.presentation

sealed interface OnboardingEvent {
    object completeOnboarding : OnboardingEvent
}
