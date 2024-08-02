package com.example.paymentreminder.authentication.presentation.login

sealed interface LoginEvent {
    data class EmailChanged(val email : String): LoginEvent
    data class PasswordChange(val password : String): LoginEvent
    data object Login : LoginEvent
}