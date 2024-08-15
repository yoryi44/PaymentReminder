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

    /****
     * Método encargado de realizar el registro con el email y contraseña
     * Desarrollador: Jorge Meza
     * 13/08/2024
     * @param email
     * @param password
     * */
    override suspend fun signup(email: String, password: String): Result<Unit> {
        return try {
            Firebase.auth.createUserWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        }
        catch (e:Exception)
        {
            Result.failure(e)
        }
    }

    /****
     * Método encargado de retorna el id del usuario logeado
     * por Firebase
     * Desarrollador: Jorge Meza
     * 08/08/2024
     */
    override fun getUserId(): String? {
        return Firebase.auth.currentUser?.uid
    }
}