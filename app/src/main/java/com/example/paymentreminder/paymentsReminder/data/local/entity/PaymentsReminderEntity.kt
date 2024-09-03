package com.example.paymentreminder.paymentsReminder.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PaymentsReminderEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val amount: Double,
    val createdAt: String,
    val currency: String,
    val dueDate: String,
    val notes: String,
    val reminderDate: String,
    val status: String,
    val updatedAt: String,
    val userId: String
)
