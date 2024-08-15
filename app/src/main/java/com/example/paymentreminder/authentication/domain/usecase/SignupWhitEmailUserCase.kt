package com.example.paymentreminder.authentication.domain.usecase

import com.example.paymentreminder.authentication.domain.repository.Authentificationrepository

class SignupWhitEmailUserCase(
    private val authentificationrepository: Authentificationrepository
) {
    suspend operator fun invoke(email: String, password: String) : Result<Unit> {
        return authentificationrepository.signup(email,password)
    }
}