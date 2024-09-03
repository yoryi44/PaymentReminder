package com.example.paymentreminder.paymentsReminder.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PaymentsReminderDto(
    @SerializedName("id") val id: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("dueDate") val dueDate: String,
    @SerializedName("notes") val notes: String,
    @SerializedName("reminderDate") val reminderDate: String,
    @SerializedName("status") val status: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("userId") val userId: String
)