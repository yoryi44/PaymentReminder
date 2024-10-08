package com.example.paymentreminder.paymentsReminder.data.mapper

import android.annotation.SuppressLint
import com.example.paymentreminder.extensionFunctions.toLocalDate
import com.example.paymentreminder.paymentsReminder.data.local.entity.PaymentsReminderEntity
import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderResponse
import com.example.paymentreminder.paymentsReminder.presentation.models.PaymentReminder
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

@SuppressLint("NewApi")
fun PaymentsReminderResponse.toDomain() : List<PaymentReminder>{
    return this.map {
        val id = it.key
        val payment = it.value
        PaymentReminder(
            id = id,
            userId = payment.userId,
            amount = payment.amount,
            currency = payment.currency,
            dueDate = payment.dueDate,
            reminderDate = payment.reminderDate,
            status = payment.status,
            notes = payment.notes,
            createdAt = payment.createdAt,
            updatedAt = payment.updatedAt,
            arrears = Period.between(payment.dueDate.toLocalDate(), LocalDate.now()).days
        )
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
        notes = notes,
        createdAt = createdAt,
        updatedAt = updatedAt,
        arrears = ChronoUnit.DAYS.between(dueDate.toLocalDate(), LocalDate.now()).toInt()
    )
}