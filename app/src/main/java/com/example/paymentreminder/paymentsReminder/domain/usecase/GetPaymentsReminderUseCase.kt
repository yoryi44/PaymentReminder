package com.example.paymentreminder.paymentsReminder.domain.usecase

import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.withContext

class GetPaymentsReminderUseCase (
    private val paymentsReminderRepository: PaymentsReminderRepository
){
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        paymentsReminderRepository.getPaymentsReminder().distinctUntilChanged()
    }
}