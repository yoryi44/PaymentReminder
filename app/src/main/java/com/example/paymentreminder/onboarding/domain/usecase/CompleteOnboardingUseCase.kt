package com.example.paymentreminder.onboarding.domain.usecase

import com.example.paymentreminder.onboarding.domain.repository.OnboardingRepository

class CompleteOnboardingUseCase(
    private val onboardingRepository: OnboardingRepository
) {
    operator fun invoke() {
        onboardingRepository.completeOnboarding()
    }
}