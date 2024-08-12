package com.example.paymentreminder.paymentList.presentation

data class PaymentListState(
    val filter: String = "",
    val search: String = "",
    val onLoading: Boolean = false,
)
