package com.example.paymentreminder.authentication.domain.EmailMatcher

interface EmailMatcher {
    fun isValid(email: String): Boolean

}