package com.example.paymentreminder.detail.domain.repository

import com.example.paymentreminder.home.presentation.models.PaymentReminderDetail

interface DetailRepository {
    suspend fun getPaymentReminderById(id: String): PaymentReminderDetail
    suspend fun insertPaymentReminder(payment: PaymentReminderDetail)
}