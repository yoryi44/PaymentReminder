package com.example.paymentreminder.authentication.domain.repository

interface Authentificationrepository {
    suspend fun login(email : String, password: String) : Result<Unit>
    suspend fun signup(email : String, password: String) : Result<Unit>
    fun getUserId() : String?
}