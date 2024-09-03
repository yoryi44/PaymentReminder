package com.example.paymentreminder.paymentsReminder.data.di

import android.content.Context
import androidx.room.Room
import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDao
import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDataBase
import com.example.paymentreminder.paymentsReminder.data.remote.PaymentsReminderApi
import com.example.paymentreminder.paymentsReminder.data.repository.PaymentsReminderRepositoryImpl
import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import com.example.paymentreminder.paymentsReminder.domain.usecase.GetPaymentsReminderSearchUseCase
import com.example.paymentreminder.paymentsReminder.domain.usecase.GetPaymentsReminderUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PaymentsReminderModule {

    private const val PAYMENTS_REMINDER_DATABASE = "paymentsReminder.db"

    @Provides
    @Singleton
    fun providePaymentsReminderRepository(paymentsReminderApi: PaymentsReminderApi, paymentsReminderDao: PaymentsReminderDao) : PaymentsReminderRepository {
        return PaymentsReminderRepositoryImpl(paymentsReminderApi,paymentsReminderDao)
    }


    @Provides
    @Singleton
    fun provideGetPaymentsReminderUseCase(paymentsReminderRepository: PaymentsReminderRepository) : GetPaymentsReminderUseCase {
        return GetPaymentsReminderUseCase(paymentsReminderRepository)
    }

    @Provides
    @Singleton
    fun provideGetPaymentsReminderSearchUseCase(paymentsReminderRepository: PaymentsReminderRepository) : GetPaymentsReminderSearchUseCase {
        return GetPaymentsReminderSearchUseCase(paymentsReminderRepository)
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

    @Singleton
    @Provides
    fun providePaymentsReminderDataBase(@ApplicationContext context: Context) : PaymentsReminderDataBase {
        return Room.databaseBuilder(context, PaymentsReminderDataBase::class.java,PAYMENTS_REMINDER_DATABASE).build()
    }

    @Singleton
    @Provides
    fun providePaymentsReminderDao(db: PaymentsReminderDataBase) = db.paymentsReminderDao

}