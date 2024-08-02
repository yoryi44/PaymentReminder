package com.example.paymentreminder.authentication.data.matcher

import android.util.Patterns
import com.example.paymentreminder.authentication.domain.EmailMatcher.EmailMatcher

class EmailMatcherImpl : EmailMatcher {
    override fun isValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}