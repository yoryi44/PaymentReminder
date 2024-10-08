package com.example.paymentreminder.detail.domain.usecase

import com.example.paymentreminder.detail.domain.repository.DetailRepository
import com.example.paymentreminder.home.presentation.models.PaymentReminderDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPaymentReminderByIdUseCase(
    private val detailRepository: DetailRepository
) {
    suspend operator fun invoke(id: String) : PaymentReminderDetail = withContext(Dispatchers.IO) {
        detailRepository.getPaymentReminderById(id)
    }
}