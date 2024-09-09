package com.example.paymentreminder.paymentsReminder.data.mapper

import android.annotation.SuppressLint
import com.example.paymentreminder.extensionFunctions.toLocalDate
import com.example.paymentreminder.paymentsReminder.data.local.entity.PaymentsReminderEntity
import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderResponse
import com.example.paymentreminder.paymentsReminder.models.PaymentReminder
import java.time.LocalDate
import java.time.Period

@SuppressLint("NewApi")
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
            updatedAt = it.updatedAt,
            arrears = Period.between(it.dueDate.toLocalDate(), LocalDate.now()).days
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

@SuppressLint("NewApi")
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
        updatedAt = updatedAt,
        arrears = Period.between(dueDate.toLocalDate(), LocalDate.now()).days
    )
}