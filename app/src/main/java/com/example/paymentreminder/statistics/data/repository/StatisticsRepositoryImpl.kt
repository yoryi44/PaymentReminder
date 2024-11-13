package com.example.paymentreminder.statistics.data.repository

import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDao
import com.example.paymentreminder.statistics.data.mapper.toDomain
import com.example.paymentreminder.statistics.domain.repository.StatisticsRepository
import com.example.paymentreminder.statistics.presentation.models.Statistics

class StatisticsRepositoryImpl(
    private val dao: PaymentsReminderDao
) : StatisticsRepository {

    override suspend fun getStatistics(): List<Statistics> {
        return dao.getStatistics().map { it.toDomain() }
    }

}