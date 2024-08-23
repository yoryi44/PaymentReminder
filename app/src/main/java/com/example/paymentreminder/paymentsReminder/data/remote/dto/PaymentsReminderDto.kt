package com.example.paymentreminder.paymentsReminder.data.remote.dto

import java.time.ZonedDateTime

data class PaymentsReminderDto(
    val _id: String,
    val amount: Double,
    val created_at: String,
    val currency: String,
    val due_date: String,
    val notes: String,
    val reminder_date: String,
    val status: String,
    val updated_at: String,
    val user_id: String
)