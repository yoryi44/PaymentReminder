package com.example.paymentreminder.statistics.data.mapper
import com.example.paymentreminder.paymentsReminder.data.dto.StatisticsDto
import com.example.paymentreminder.statistics.presentation.models.Statistics

fun StatisticsDto.toDomain(): Statistics {
    return Statistics(
        amount = this.amount,
        category = this.category
    )
}