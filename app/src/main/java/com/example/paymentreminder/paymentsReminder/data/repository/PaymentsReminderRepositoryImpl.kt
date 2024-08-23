package com.example.paymentreminder.paymentsReminder.data.repository

import com.example.home_data.remote.util.resultOf
import com.example.paymentreminder.paymentsReminder.data.mapper.toDomain
import com.example.paymentreminder.paymentsReminder.data.remote.PaymentsReminderApi
import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import com.example.paymentreminder.paymentsReminder.models.PaymentReminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

class PaymentsReminderRepositoryImpl(
    private val paymentsReminderApi: PaymentsReminderApi
) : PaymentsReminderRepository {

    override fun getPaymentsReminder() : Flow<List<PaymentReminder>> {
        return flow {

            var habits = emptyList<PaymentReminder>()

            resultOf {
                habits = paymentsReminderApi.getAllHabits().toDomain()
//                insertHabits(habits)
            }.onSuccess {
                emit(habits)
            }.onFailure {
                val r = it.message
                emit(emptyList<PaymentReminder>())
            }

        }.onStart {
            emptyList<PaymentReminder>()
        }
    }
}