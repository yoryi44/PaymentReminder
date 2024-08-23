package com.example.paymentreminder.paymentsReminder.data.di

import com.example.paymentreminder.paymentsReminder.data.remote.PaymentsReminderApi
import com.example.paymentreminder.paymentsReminder.data.repository.PaymentsReminderRepositoryImpl
import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import com.example.paymentreminder.paymentsReminder.domain.usecase.GetPaymentsReminderUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PaymentsReminderModule {

    @Provides
    @Singleton
    fun providePaymentsReminderRepository(paymentsReminderApi: PaymentsReminderApi) : PaymentsReminderRepository {
        return PaymentsReminderRepositoryImpl(paymentsReminderApi)
    }


    @Provides
    @Singleton
    fun provideGetPaymentsReminderUseCase(paymentsReminderRepository: PaymentsReminderRepository) : GetPaymentsReminderUseCase {
        return GetPaymentsReminderUseCase(paymentsReminderRepository)
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build()
    }

    @Provides
    @Singleton
    fun providePaymentsReminderApi(client: OkHttpClient) : PaymentsReminderApi {
        return Retrofit.Builder().baseUrl(PaymentsReminderApi.BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PaymentsReminderApi::class.java)
    }

}