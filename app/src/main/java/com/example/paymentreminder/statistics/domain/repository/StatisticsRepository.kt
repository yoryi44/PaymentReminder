package com.example.paymentreminder.statistics.domain.repository

import com.example.paymentreminder.statistics.presentation.models.Statistics


interface StatisticsRepository {

    suspend fun getStatistics(): List<Statistics>
}