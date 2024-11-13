package com.example.paymentreminder.statistics.data.di

import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDao
import com.example.paymentreminder.statistics.data.repository.StatisticsRepositoryImpl
import com.example.paymentreminder.statistics.domain.repository.StatisticsRepository
import com.example.paymentreminder.statistics.domain.usecase.GetStatisticsUserCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object statisticsModule {

    @Provides
    @Singleton
    fun providestatisticsRepository(paymentsReminderDao: PaymentsReminderDao): StatisticsRepository {
        return StatisticsRepositoryImpl(paymentsReminderDao)
    }

    @Provides
    @Singleton
    fun provideGetStatisticsUserCase(statisticsRepository: StatisticsRepository): GetStatisticsUserCase {
        return GetStatisticsUserCase(statisticsRepository)
    }


}