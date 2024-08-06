package com.example.paymentreminder.onboarding.domain.repository

interface OnboardingRepository {
    fun hasSeenOnboarding() : Boolean
    fun completeOnboarding()
}