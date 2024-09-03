package com.example.paymentreminder.paymentsReminder.domain.usecase

import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository

class GetPaymentsReminderSearchUseCase (
    private val paymentsReminderRepository: PaymentsReminderRepository
){
    operator fun invoke(searchQuery: String, orderBy: String) = paymentsReminderRepository.getPaymentsReminderSearch(searchQuery, orderBy)
}