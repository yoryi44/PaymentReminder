package com.example.paymentreminder.paymentsReminder.data.repository

import androidx.work.BackoffPolicy
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.home_data.remote.util.resultOf
import com.example.paymentreminder.home.sync.PaymentReminderSyncWorker
import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDao
import com.example.paymentreminder.paymentsReminder.data.mapper.toDomain
import com.example.paymentreminder.paymentsReminder.data.mapper.toEntity
import com.example.paymentreminder.paymentsReminder.data.remote.PaymentsReminderApi
import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import com.example.paymentreminder.paymentsReminder.presentation.models.PaymentReminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import java.time.Duration

class PaymentsReminderRepositoryImpl(
    private val paymentsReminderApi: PaymentsReminderApi,
    private val paymentsReminderDao: PaymentsReminderDao,
    private val workManager: WorkManager
) : PaymentsReminderRepository {

    override suspend fun getPaymentsReminder() : Flow<List<PaymentReminder>> {
        val localFlow = paymentsReminderDao.getAllPaymentsReminder()
            .map { paymentsReminder -> paymentsReminder.map { it.toDomain() } }

        val apiFlow = getHabitsFromApi()

        return localFlow.combine(apiFlow) { db, api -> db }
    }

    override suspend fun getPaymentsReminderSearch(searchQuery: String, orderBy: String): Flow<List<PaymentReminder>> {
        return paymentsReminderDao.getPaymentsReminderSearch(searchQuery, orderBy).map {
            paymentsReminder -> paymentsReminder.map { it.toDomain() }
        }
    }

    private fun getHabitsFromApi() : Flow<List<PaymentReminder>> {
        return flow {
            resultOf {
                val paymentsReminder = paymentsReminderApi.getAllHabits().toDomain().sortedBy { it.createdAt }
                insertPaymentsReminder(paymentsReminder)
            }
            emit(emptyList<PaymentReminder>())

        }.onStart {
            emptyList<PaymentReminder>()
        }
    }

    override suspend fun insertPaymentsReminder(paymentsReminder: List<PaymentReminder>) {
        paymentsReminder.forEach {
            paymentsReminderDao.insertPaymentReminder(it.toEntity())
        }
    }

    override suspend fun syncClient() {
        val worker = OneTimeWorkRequestBuilder<PaymentReminderSyncWorker>().setConstraints(
            Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        ).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, Duration.ofMinutes(5))
            .build()

        workManager.beginUniqueWork("payment_reminder_id", ExistingWorkPolicy.REPLACE, worker).enqueue()
    }
}