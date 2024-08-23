package com.example.paymentreminder.paymentsReminder.models

data class PaymentReminder(
    val id: String,            // ID único del recordatorio
    val userId: String,        // ID del usuario
    val amount: Double,        // Monto del pago
    val currency: String,      // Moneda del pago
    val dueDate: String,       // Fecha de vencimiento del pago
    val reminderDate: String,  // Fecha de recordatorio
    val status: String,        // Estado del pago (pending, paid, overdue)
    val notes: String?,        // Notas adicionales
    val createdAt: String,     // Fecha de creación del recordatorio
    val updatedAt: String      // Fecha de última actualización del recordatorio
)