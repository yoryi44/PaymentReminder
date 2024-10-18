package com.example.paymentreminder.paymentsReminder.data.mapper

import android.annotation.SuppressLint
import com.example.paymentreminder.R
import com.example.paymentreminder.extensionFunctions.toLocalDate
import com.example.paymentreminder.paymentsReminder.data.local.entity.PaymentsReminderEntity
import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderResponse
import com.example.paymentreminder.paymentsReminder.presentation.models.PaymentReminder
import com.example.paymentreminder.ui.theme.Danger
import com.example.paymentreminder.ui.theme.Success
import com.example.paymentreminder.ui.theme.Warning
import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

@SuppressLint("NewApi")
fun PaymentsReminderResponse.toDomain(): List<PaymentReminder> {
    return this.map {
        val id = it.key
        val payment = it.value
        val  arrears = Period.between(payment.dueDate.toLocalDate(), LocalDate.now()).days
        PaymentReminder(
            id = id,
            userId = payment.userId,
            amount = payment.amount,
            currency = payment.currency,
            dueDate = payment.dueDate,
            reminderDate = payment.reminderDate,
            status = payment.status,
            category = payment.category,
            notes = payment.notes,
            createdAt = payment.createdAt,
            updatedAt = payment.updatedAt,
            arrears = arrears,
            color = getColor(arrears),
            title = getTitle(arrears)
        )
    }
}

fun PaymentReminder.toEntity(): PaymentsReminderEntity {
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

fun PaymentsReminderEntity.toDomain(): PaymentReminder {
    val arrears = Period.between(dueDate.toLocalDate(), LocalDate.now()).days
    return PaymentReminder(
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
        arrears = if(arrears < 0) arrears * -1 else arrears,
        color = getColor(arrears),
        title = getTitle(arrears)
    )
}

fun getTitle(arrears: Int) = when {
    arrears < 0 -> {
        R.string.days_next_payment
    }

    arrears > 3 -> {
        R.string.arrears
    }

    else -> {
        R.string.arrears
    }
}

fun getColor(arrears: Int) = when {
    arrears < 0 -> {
        Success
    }

    arrears > 3 -> {
        Danger
    }

    else -> {
        Warning
    }
}