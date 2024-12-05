package com.example.paymentreminder.paymentsReminder.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paymentreminder.detail.data.local.entity.PaymentReminderSyncEntity
import com.example.paymentreminder.paymentsReminder.data.dto.StatisticsDto
import com.example.paymentreminder.paymentsReminder.data.local.entity.PaymentsReminderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentsReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaymentReminder(paymentsReminderEntity: PaymentsReminderEntity)

    @Query("SELECT * FROM PaymentsReminderEntity ORDER BY createdAt DESC")
    fun getAllPaymentsReminder(): Flow<List<PaymentsReminderEntity>>

    @Query("SELECT amount,category FROM PaymentsReminderEntity ORDER BY createdAt DESC")
    fun getStatistics(): List<StatisticsDto>

    @Query("SELECT * FROM PaymentsReminderEntity WHERE id = :id")
    fun getPaymentReminderById(id: String): PaymentsReminderEntity

    @Query("SELECT * FROM PaymentsReminderEntity " +
            "WHERE notes LIKE '%' || :searchQuery || '%' " +
            "OR amount LIKE '%' || :searchQuery || '%' " +
            "ORDER BY " +
            "CASE WHEN :orderBy = 'amount' THEN CAST(amount AS INTEGER) ELSE dueDate END ASC"
    )
    fun getPaymentsReminderSearch(searchQuery: String, orderBy: String): Flow<List<PaymentsReminderEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaymentReminderSync(habitSyncEntity: PaymentReminderSyncEntity)

    @Query("SELECT * FROM PaymentReminderSyncEntity")
    fun getAllPaymentsReminderSync(): List<PaymentReminderSyncEntity>

    @Delete
    suspend fun deletePaymentReminderSync(paymentReminderSyncEntity: PaymentReminderSyncEntity)

}