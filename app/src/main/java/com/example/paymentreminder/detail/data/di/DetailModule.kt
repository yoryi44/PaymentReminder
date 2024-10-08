package com.example.paymentreminder.detail.data.di

import com.example.paymentreminder.detail.data.repository.DetailRepositoryImpl
import com.example.paymentreminder.detail.domain.repository.DetailRepository
import com.example.paymentreminder.detail.domain.usecase.GetPaymentReminderByIdUseCase
import com.example.paymentreminder.detail.domain.usecase.InsertPaymentReminderUseCase
import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDao
import com.example.paymentreminder.paymentsReminder.data.remote.PaymentsReminderApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DetailModule {

    @Provides
    @Singleton
    fun provideDetailRepository(paymentsReminderDao: PaymentsReminderDao, api: PaymentsReminderApi): DetailRepository {
        return DetailRepositoryImpl(paymentsReminderDao,api)
    }

    @Provides
    @Singleton
    fun provideGetPaymentReminderByIdUseCase(detailRepository: DetailRepository): GetPaymentReminderByIdUseCase {
        return GetPaymentReminderByIdUseCase(detailRepository)
    }

    @Provides
    @Singleton
    fun provideInsertPaymentReminderUseCase(detailRepository: DetailRepository): InsertPaymentReminderUseCase {
        return InsertPaymentReminderUseCase(detailRepository)
    }

}