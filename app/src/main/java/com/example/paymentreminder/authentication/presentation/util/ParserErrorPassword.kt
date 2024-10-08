package com.example.paymentreminder.authentication.presentation.util

import com.example.paymentreminder.R
import com.example.paymentreminder.authentication.domain.usecase.PaswordResult

object ParserErrorPassword {
    operator fun invoke(error : PaswordResult):String? {
        return when(error) {
            PaswordResult.VALID -> null
            PaswordResult.INVALID_LOWERCASE -> R.string.password_lowercase_error.toString()
            PaswordResult.INVALID_UPPERCASE -> R.string.password_uppercase_error.toString()
            PaswordResult.INVALID_DIGITS -> R.string.password_digit_error.toString()
            PaswordResult.INVALID_LENGTH -> R.string.password_lenght_error.toString()
        }
    }
}