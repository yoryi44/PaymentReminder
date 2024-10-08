package com.example.paymentreminder.detail.data.repository

import com.example.home_data.remote.util.resultOf
import com.example.paymentreminder.detail.data.mapper.toDetailDomain
import com.example.paymentreminder.detail.data.mapper.toDto
import com.example.paymentreminder.detail.data.mapper.toEntity
import com.example.paymentreminder.detail.data.mapper.toSyncEntity
import com.example.paymentreminder.detail.domain.repository.DetailRepository
import com.example.paymentreminder.home.presentation.models.PaymentReminderDetail
import com.example.paymentreminder.paymentsReminder.data.local.PaymentsReminderDao
import com.example.paymentreminder.paymentsReminder.data.remote.PaymentsReminderApi

class DetailRepositoryImpl(
    private val dao: PaymentsReminderDao,
    private val api: PaymentsReminderApi
) : DetailRepository {

    override suspend fun getPaymentReminderById(id: String): PaymentReminderDetail {
        return dao.getPaymentReminderById(id).toDetailDomain()
    }

    override suspend fun insertPaymentReminder(payment: PaymentReminderDetail) {
        dao.insertPaymentReminder(payment.toEntity())
        resultOf {
            api.insertPaymentReminder(payment.toDto())
        }.onFailure {
            dao.insertPaymentReminderSync(payment.toSyncEntity())
        }
    }

}