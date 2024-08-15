package com.example.paymentreminder.authentication.presentation.signup

data class SignupState(
    val email : String = "",
    val emailError : String? = null,
    val password : String = "",
    val passwordError : String? = null,
    val isLoading : Boolean = false,
    val isSignedIn : Boolean = false
)
