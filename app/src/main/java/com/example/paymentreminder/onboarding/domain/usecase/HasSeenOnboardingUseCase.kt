package com.example.paymentreminder.onboarding.domain.usecase

import com.example.paymentreminder.onboarding.domain.repository.OnboardingRepository

class HasSeenOnboardingUseCase(
    private val onboardingRepository: OnboardingRepository
) {
    operator fun invoke(): Boolean {
        return onboardingRepository.hasSeenOnboarding()
    }
}