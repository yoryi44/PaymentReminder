package com.example.paymentreminder.statistics.domain.usecase

import com.example.paymentreminder.statistics.domain.repository.StatisticsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetStatisticsUserCase(
    private val statisticsRepository: StatisticsRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        statisticsRepository.getStatistics()
    }
}