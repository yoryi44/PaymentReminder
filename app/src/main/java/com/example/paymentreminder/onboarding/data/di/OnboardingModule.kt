package com.example.paymentreminder.onboarding.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.paymentreminder.onboarding.data.repository.OnboardingRepositoryImpl
import com.example.paymentreminder.onboarding.domain.repository.OnboardingRepository
import com.example.paymentreminder.onboarding.domain.usecase.CompleteOnboardingUseCase
import com.example.paymentreminder.onboarding.domain.usecase.HasSeenOnboardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OnboardingModule {

    @Provides
    @Singleton
    fun provideOnboardingRepository(sharedPreferences: SharedPreferences) : OnboardingRepository {
        return OnboardingRepositoryImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideHasSeenOnboardingUseCase(onboardingRepository: OnboardingRepository) : HasSeenOnboardingUseCase {
        return HasSeenOnboardingUseCase(onboardingRepository)
    }

    @Provides
    @Singleton
    fun provideCompleteOnboardingUseCase(onboardingRepository: OnboardingRepository) : CompleteOnboardingUseCase {
        return CompleteOnboardingUseCase(onboardingRepository)
    }

    @Provides
    @Singleton
    fun sharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("habit_onboarding_preferences", Context.MODE_PRIVATE)
    }
}