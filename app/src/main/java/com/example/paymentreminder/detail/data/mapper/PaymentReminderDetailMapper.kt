package com.example.paymentreminder.detail.data.mapper

import com.example.paymentreminder.detail.data.local.entity.PaymentReminderSyncEntity
import com.example.paymentreminder.extensionFunctions.toLocalDate
import com.example.paymentreminder.home.presentation.models.PaymentReminderDetail
import com.example.paymentreminder.paymentsReminder.data.local.entity.PaymentsReminderEntity
import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderDto
import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderResponse
import java.time.LocalDate
import java.time.Period

fun PaymentsReminderEntity.toDetailDomain(): PaymentReminderDetail {
    return PaymentReminderDetail(
        id = id,
        userId = userId,
        amount = amount,
        currency = currency,
        dueDate = dueDate,
        reminderDate = reminderDate,
        status = status,
        category = category,
        notes = notes,
        createdAt = createdAt,
        updatedAt = updatedAt,
        arrears = Period.between(dueDate.toLocalDate(), LocalDate.now()).days
    )
}

fun PaymentReminderDetail.toEntity() : PaymentsReminderEntity {
    return PaymentsReminderEntity(
        id = id,
        userId = userId,
        amount = amount,
        currency = currency,
        dueDate = dueDate,
        reminderDate = reminderDate,
        status = status,
        category = category,
        notes = notes ?: "",
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}

fun PaymentReminderDetail.toDto() : PaymentsReminderResponse {
    val dto = PaymentsReminderDto(
        id = id,
        userId = userId,
        amount = amount,
        currency = currency,
        dueDate = dueDate,
        reminderDate = reminderDate,
        status = status,
        category = category,
        notes = notes ?: "",
        createdAt = createdAt,
        updatedAt = updatedAt
    )

    return mapOf(id to dto)
}

fun PaymentReminderDetail.toSyncEntity() : PaymentReminderSyncEntity {
    return PaymentReminderSyncEntity(
        id = id,
    )
}