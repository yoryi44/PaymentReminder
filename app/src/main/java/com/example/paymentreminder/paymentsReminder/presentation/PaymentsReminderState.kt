package com.example.paymentreminder.paymentsReminder.presentation

import com.example.paymentreminder.paymentsReminder.presentation.models.PaymentReminder

data class PaymentsReminderState(
    val filter: String = "",
    val search: String = "",
    val onLoading: Boolean = false,
    val paymentsReminder: List<PaymentReminder> = emptyList(),
    val isLoading : Boolean = false
)
