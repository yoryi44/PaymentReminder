package com.example.paymentreminder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.paymentreminder.authentication.domain.usecase.GetUserIdUseCase
import com.example.paymentreminder.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    hasSeenOnboardingUseCase: HasSeenOnboardingUseCase,
    getUserIdUseCase: GetUserIdUseCase
) : ViewModel() {

    var hasSeenOnboarding by mutableStateOf(false)
        private set

    var isLoggedIn by mutableStateOf(false)
        private set

    var isLoading by mutableStateOf(true)
        private set

    init {
        hasSeenOnboarding = hasSeenOnboardingUseCase()
        isLoggedIn = getUserIdUseCase() != null
        isLoading = false
    }

}