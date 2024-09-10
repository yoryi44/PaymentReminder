package com.example.paymentreminder.paymentsReminder.domain.usecase

import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetPaymentsReminderSearchUseCase (
    private val paymentsReminderRepository: PaymentsReminderRepository
){
    suspend operator fun invoke(searchQuery: String, orderBy: String) = withContext(Dispatchers.IO)
    {
        paymentsReminderRepository.getPaymentsReminderSearch(searchQuery, orderBy)
    }
}