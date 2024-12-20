package com.example.paymentreminder.paymentsReminder.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paymentreminder.detail.data.local.entity.PaymentReminderSyncEntity
import com.example.paymentreminder.paymentsReminder.data.local.entity.PaymentsReminderEntity

@Database(entities = [PaymentsReminderEntity::class,PaymentReminderSyncEntity::class], version = 1)
abstract class PaymentsReminderDataBase : RoomDatabase() {
    abstract val paymentsReminderDao : PaymentsReminderDao
}