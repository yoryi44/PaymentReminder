package com.example.paymentreminder.paymentsReminder.data.repository

import com.example.home_data.remote.util.resultOf
import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDao
import com.example.paymentreminder.paymentsReminder.data.mapper.toDomain
import com.example.paymentreminder.paymentsReminder.data.mapper.toEntity
import com.example.paymentreminder.paymentsReminder.data.remote.PaymentsReminderApi
import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import com.example.paymentreminder.paymentsReminder.models.PaymentReminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class PaymentsReminderRepositoryImpl(
    private val paymentsReminderApi: PaymentsReminderApi,
    private val paymentsReminderDao: PaymentsReminderDao
) : PaymentsReminderRepository {

    override fun getPaymentsReminder() : Flow<List<PaymentReminder>> {
        val localFlow = paymentsReminderDao.getAllPaymentsReminder()
            .map { paymentsReminder -> paymentsReminder.map { it.toDomain() } }

        val apiFlow = getHabitsFromApi()

        return localFlow.combine(apiFlow) { db, api -> db }
    }

    override fun getPaymentsReminderSearch(searchQuery: String, orderBy: String): Flow<List<PaymentReminder>> {
        return paymentsReminderDao.getPaymentsReminderSearch(searchQuery, orderBy).map {
            paymentsReminder -> paymentsReminder.map { it.toDomain() }
        };
    }

    private fun getHabitsFromApi() : Flow<List<PaymentReminder>> {
        return flow {

            resultOf {
                val paymentsReminder = paymentsReminderApi.getAllHabits().toDomain()
                insertPaymentsReminder(paymentsReminder)
            }

            emit(emptyList<PaymentReminder>())

        }.onStart {
            emptyList<PaymentReminder>()
        }
    }

    override suspend fun insertPaymentsReminder(paymentsReminder: List<PaymentReminder>) {
        paymentsReminder.forEach {
            paymentsReminderDao.insertPaymentsReminder(it.toEntity())
        }
    }
}