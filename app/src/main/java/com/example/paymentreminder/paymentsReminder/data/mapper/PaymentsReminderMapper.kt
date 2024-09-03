package com.example.paymentreminder.paymentsReminder.data.mapper

import com.example.paymentreminder.paymentsReminder.data.local.entity.PaymentsReminderEntity
import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderResponse
import com.example.paymentreminder.paymentsReminder.models.PaymentReminder

fun PaymentsReminderResponse.toDomain() : List<PaymentReminder>{
    return this.map {
        val paymentReminder = PaymentReminder(
            id = it.id,
            userId = it.userId,
            amount = it.amount,
            currency = it.currency,
            dueDate = it.dueDate,
            reminderDate = it.reminderDate,
            status = it.status,
            notes = it.notes,
            createdAt = it.createdAt,
            updatedAt = it.updatedAt
        )
        paymentReminder
    }
}

fun PaymentReminder.toEntity() : PaymentsReminderEntity {
        return PaymentsReminderEntity(
            id = id,
            userId = userId,
            amount = amount,
            currency = currency,
            dueDate = dueDate,
            reminderDate = reminderDate,
            status = status,
            notes = notes ?: "",
            createdAt = createdAt,
            updatedAt = updatedAt
        )
}

fun PaymentsReminderEntity.toDomain() : PaymentReminder {
    return PaymentReminder(
        id = id,
        userId = userId,
        amount = amount,
        currency = currency,
        dueDate = dueDate,
        reminderDate = reminderDate,
        status = status,
        notes = notes ?: "",
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}