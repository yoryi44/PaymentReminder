package com.example.paymentreminder.paymentsReminder.domain.repository

import com.example.paymentreminder.paymentsReminder.models.PaymentReminder
import kotlinx.coroutines.flow.Flow

interface PaymentsReminderRepository {

    fun getPaymentsReminder() : Flow<List<PaymentReminder>>
}