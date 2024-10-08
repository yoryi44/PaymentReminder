package com.example.paymentreminder.home.presentation.models

data class PaymentReminderDetail(
    val id: String,            // ID único del recordatorio
    val userId: String,        // ID del usuario
    val amount: String,        // Monto del pago
    val currency: String,      // Moneda del pago
    val dueDate: String,       // Fecha de vencimiento del pago
    val reminderDate: String,  // Fecha de recordatorio
    val status: String,        // Estado del pago (pending, paid, overdue)
    val notes: String?,        // Notas adicionales
    val createdAt: String,     // Fecha de creación del recordatorio
    val updatedAt: String,     // Fecha de última actualización del recordatorio
    val arrears: Int           // Dias en mora
)