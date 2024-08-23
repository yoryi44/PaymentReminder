package com.example.paymentreminder.paymentsReminder.data.remote

import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderDto
import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderResponse
import retrofit2.http.GET

interface PaymentsReminderApi {

    companion object{
        const val BASE_URL = "https://my-appstore-apps-default-rtdb.firebaseio.com/"
    }

    @GET(".json")
    suspend fun getAllHabits(): List<PaymentsReminderDto>

}