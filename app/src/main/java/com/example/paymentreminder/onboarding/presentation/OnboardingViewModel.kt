package com.example.paymentreminder.onboarding.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.paymentreminder.onboarding.domain.usecase.CompleteOnboardingUseCase
import com.example.paymentreminder.onboarding.domain.usecase.HasSeenOnboardingUseCase
import com.example.paymentreminder.onboarding.presentation.components.OnboardingState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val hasSeenOnboardingUseCase: HasSeenOnboardingUseCase,
    private val completeOnboardingUseCase: CompleteOnboardingUseCase
) : ViewModel() {

    var state by mutableStateOf(OnboardingState())
        private set

    init{
        state = state.copy(
            hasSeenOnboarding = hasSeenOnboardingUseCase()
        )
    }

    fun onEvent(event : OnboardingEvent) {

        when(event) {
            OnboardingEvent.completeOnboarding ->
            {
                completeOnboardingUseCase()
                state = state.copy(
                    hasSeenOnboarding = true
                )
            }
        }
    }

}