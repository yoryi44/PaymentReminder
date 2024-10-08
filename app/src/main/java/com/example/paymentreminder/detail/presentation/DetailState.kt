package com.example.paymentreminder.detail.presentation

import java.math.BigDecimal

data class DetailState (
    val id: String = "",
    val userId: String = "",
    val amount: String = "",
    val currency: String = "",
    val dueDate: String = "",
    val reminderDate: String = "",
    val status: String = "",
    val notes: String? = null,
    val createdAt: String = "",
    val updatedAt: String = "",
    val isLoading: Boolean = false,
    val isSave: Boolean = false,
)