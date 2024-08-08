package com.example.paymentreminder.authentication.domain.usecase

import com.example.paymentreminder.authentication.domain.repository.Authentificationrepository

class GetUserIdUseCase(
    private val authentificationrepository: Authentificationrepository
) {
    operator fun invoke(): String? {
        return authentificationrepository.getUserId()
    }
}