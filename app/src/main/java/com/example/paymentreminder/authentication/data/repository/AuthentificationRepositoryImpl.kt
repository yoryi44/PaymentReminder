package com.example.paymentreminder.authentication.data.repository

import com.example.paymentreminder.authentication.domain.repository.Authentificationrepository
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

class AuthentificationRepositoryImpl:Authentificationrepository {


    /****
     * Método encargado de realizar el login con el usuario y contraseña
     * Desarrollador: Jorge Meza
     * 02/08/2024
     * @param email
     * @param password
     */
    override suspend fun login(email: String, password: String): Result<Unit> {
        return try {
            Firebase.auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        }
        catch (e:Exception)
        {
            Result.failure(e)
        }
    }
}