package com.example.paymentreminder.detail.presentation

import java.math.BigDecimal

sealed interface DetailEvent {
    data class amountChanged(val amount : String): DetailEvent
    data class dueDateChanged(val dueDate : String): DetailEvent
    data class notesChanged(val notes : String): DetailEvent
    object PaymentSave : DetailEvent
}
