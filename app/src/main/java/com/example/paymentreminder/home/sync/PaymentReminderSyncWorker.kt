package com.example.paymentreminder.home.sync

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.home_data.remote.util.resultOf
import com.example.paymentreminder.detail.data.local.entity.PaymentReminderSyncEntity
import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDao
import com.example.paymentreminder.paymentsReminder.data.mapper.toDomain
import com.example.paymentreminder.paymentsReminder.data.mapper.toDto
import com.example.paymentreminder.paymentsReminder.data.remote.PaymentsReminderApi
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.supervisorScope

@HiltWorker
class PaymentReminderSyncWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted val workerParameters: WorkerParameters,
    private val api: PaymentsReminderApi,
    private val dao: PaymentsReminderDao
) : CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result {
        if (runAttemptCount >= 3) {
            return Result.failure()
        }

        val items = dao.getAllPaymentsReminderSync()

        return try {
            supervisorScope {
                val jobs = items.map { items -> async { sync(items) } }
                jobs.awaitAll()
            }
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }

        return Result.success()
    }

    private suspend fun sync(entity: PaymentReminderSyncEntity) {
        val habit = dao.getPaymentReminderById(entity.id).toDomain().toDto()
        resultOf {
            api.insertPaymentReminder(habit)
        }.onSuccess {
            dao.deletePaymentReminderSync(entity)
        }.onFailure {
            throw it
        }
    }

}