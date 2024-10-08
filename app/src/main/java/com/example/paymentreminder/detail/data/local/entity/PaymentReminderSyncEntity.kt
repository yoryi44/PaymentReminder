package com.example.paymentreminder.detail.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PaymentReminderSyncEntity (
    @PrimaryKey(autoGenerate = false)
    val id:String
)