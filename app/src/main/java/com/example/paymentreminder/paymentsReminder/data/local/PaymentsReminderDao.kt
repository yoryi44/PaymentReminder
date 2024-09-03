package com.example.paymentreminder.paymentsReminder.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paymentreminder.paymentsReminder.data.local.entity.PaymentsReminderEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentsReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaymentsReminder(paymentsReminderEntity: PaymentsReminderEntity)

    @Query("SELECT * FROM PaymentsReminderEntity")
    fun getAllPaymentsReminder(): Flow<List<PaymentsReminderEntity>>

    @Query("SELECT * FROM PaymentsReminderEntity " +
            "WHERE notes LIKE '%' || :searchQuery || '%' " +
            "OR amount LIKE '%' || :searchQuery || '%' " +
            "ORDER BY :orderBy DESC"
    )
    fun getPaymentsReminderSearch(searchQuery: String, orderBy: String): Flow<List<PaymentsReminderEntity>>

}