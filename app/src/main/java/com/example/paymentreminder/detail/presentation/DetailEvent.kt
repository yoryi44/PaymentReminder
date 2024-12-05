package com.example.paymentreminder.detail.presentation

sealed interface DetailEvent {
    data class amountChanged(val amount : String): DetailEvent
    data class dueDateChanged(val dueDate : String): DetailEvent
    data class notesChanged(val notes : String): DetailEvent
    data class categoryChanged(val category : String): DetailEvent
    data class idChanged(val id : String): DetailEvent
    object PaymentSave : DetailEvent
}
