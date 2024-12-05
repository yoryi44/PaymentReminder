package com.example.paymentreminder.paymentsReminder.domain.usecase

import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SyncPaymentReminderUseCase (
    private val paymentReminderRepository: PaymentsReminderRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        paymentReminderRepository.syncClient()
    }
}