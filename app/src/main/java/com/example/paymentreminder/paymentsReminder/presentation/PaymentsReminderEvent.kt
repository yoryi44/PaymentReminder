package com.example.paymentreminder.paymentsReminder.presentation

sealed interface PaymentsReminderEvent {
    data class OnFilter(val filter: String) : PaymentsReminderEvent
    data class OnSearch(val filter: String) : PaymentsReminderEvent
}
