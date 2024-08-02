package com.example.paymentreminder.authentication.domain.usecase

import com.example.paymentreminder.authentication.domain.EmailMatcher.EmailMatcher

class ValidateEmailUseCase (
    private val emailMatcher: EmailMatcher
) {
    operator fun invoke(email: String): Boolean {
        return emailMatcher.isValid(email)
    }
}