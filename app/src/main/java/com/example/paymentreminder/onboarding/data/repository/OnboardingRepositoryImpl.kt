package com.example.paymentreminder.onboarding.data.repository

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.paymentreminder.onboarding.domain.repository.OnboardingRepository

class OnboardingRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : OnboardingRepository {

    companion object {
        private const val HAS_SEEN_ONBOARDING = "has_seen_onboarding"
    }

    override fun hasSeenOnboarding(): Boolean {
        return sharedPreferences.getBoolean(HAS_SEEN_ONBOARDING, false)
    }

    override fun completeOnboarding() {
        sharedPreferences.edit().putBoolean(HAS_SEEN_ONBOARDING, true).apply()
    }
}