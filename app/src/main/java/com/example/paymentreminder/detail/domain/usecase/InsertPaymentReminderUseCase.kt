package com.example.paymentreminder.detail.domain.usecase

import com.example.paymentreminder.detail.domain.repository.DetailRepository
import com.example.paymentreminder.home.presentation.models.PaymentReminderDetail

class InsertPaymentReminderUseCase (
    private val detailRepository: DetailRepository
) {
    suspend operator fun invoke(payment: PaymentReminderDetail) {
        detailRepository.insertPaymentReminder(payment)
    }
}