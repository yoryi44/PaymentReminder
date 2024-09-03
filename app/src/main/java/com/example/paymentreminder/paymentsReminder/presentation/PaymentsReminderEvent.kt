package com.example.paymentreminder.paymentsReminder.presentation

sealed interface PaymentsReminderEvent {
    data class OnFilter(val filter: String) : PaymentsReminderEvent
    data object OnSearch : PaymentsReminderEvent
    data class OnItemEdit(val id: String) : PaymentsReminderEvent
    data class SearchChanged(val search: String) : PaymentsReminderEvent
}
