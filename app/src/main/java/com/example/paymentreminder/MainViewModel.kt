package com.example.paymentreminder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.paymentreminder.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val hasSeenOnboardingUseCase: HasSeenOnboardingUseCase
) : ViewModel() {

    var hasSeenOnboarding by mutableStateOf(hasSeenOnboardingUseCase())
        private set

}