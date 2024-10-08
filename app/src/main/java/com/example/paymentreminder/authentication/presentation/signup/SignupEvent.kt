package com.example.paymentreminder.authentication.presentation.signup

sealed interface SignupEvent{
    data class EmailChanged(val email : String): SignupEvent
    data class PasswordChange(val password : String): SignupEvent
    data object Signup : SignupEvent
}
