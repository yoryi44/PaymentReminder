package com.example.paymentreminder.paymentsReminder.data.mapper

import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderResponse
import com.example.paymentreminder.paymentsReminder.models.PaymentReminder
import java.time.ZonedDateTime

fun PaymentsReminderResponse.toDomain() : List<PaymentReminder>{
    return this.map {
        PaymentReminder(
            id = it._id,            // ID único del recordatorio
            userId = it.user_id,        // ID del usuario
            amount = it.amount,        // Monto del pago
            currency = it.currency,      // Moneda del pago
            dueDate = it.due_date.toString(),       // Fecha de vencimiento del pago
            reminderDate = it.reminder_date.toString(),  // Fecha de recordatorio
            status = it.status,        // Estado del pago (pending, paid, overdue)
            notes = it.notes,        // Notas adicionales
            createdAt = it.created_at.toString(),     // Fecha de creación del recordatorio
            updatedAt = it.updated_at.toString()
        )
    }
}