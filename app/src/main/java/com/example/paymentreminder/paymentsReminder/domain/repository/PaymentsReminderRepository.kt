package com.example.paymentreminder.paymentsReminder.domain.repository

import com.example.paymentreminder.paymentsReminder.models.PaymentReminder
import kotlinx.coroutines.flow.Flow

interface PaymentsReminderRepository {

    suspend fun getPaymentsReminder() : Flow<List<PaymentReminder>>
    suspend fun getPaymentsReminderSearch(searchQuery: String, orderBy: String) : Flow<List<PaymentReminder>>
    suspend fun insertPaymentsReminder (paymentsReminder : List<PaymentReminder>)
}