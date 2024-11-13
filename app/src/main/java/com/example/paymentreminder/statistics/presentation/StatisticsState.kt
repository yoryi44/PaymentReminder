package com.example.paymentreminder.statistics.presentation

import com.example.paymentreminder.statistics.presentation.models.Statistics

data class StatisticsState (
    val statistics: List<Statistics> = emptyList(),
)