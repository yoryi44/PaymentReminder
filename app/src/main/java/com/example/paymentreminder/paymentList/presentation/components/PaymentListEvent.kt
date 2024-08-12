package com.example.paymentreminder.paymentList.presentation.components

sealed interface PaymentListEvent {
    data class OnFilter(val filter: String) : PaymentListEvent
    data class OnSearch(val filter: String) : PaymentListEvent
}
