package com.example.paymentreminder.paymentsReminder.domain.usecase

import com.example.paymentreminder.paymentsReminder.domain.repository.PaymentsReminderRepository

class GetPaymentsReminderUseCase (
    private val paymentsReminderRepository: PaymentsReminderRepository
){
    operator fun invoke() = paymentsReminderRepository.getPaymentsReminder()
}