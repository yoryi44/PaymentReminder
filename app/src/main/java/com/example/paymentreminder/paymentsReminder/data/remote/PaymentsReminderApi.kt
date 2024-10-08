package com.example.paymentreminder.paymentsReminder.data.remote

import com.example.paymentreminder.paymentsReminder.data.remote.dto.PaymentsReminderResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH

interface PaymentsReminderApi {

    companion object{
        const val BASE_URL = "https://my-appstore-apps-default-rtdb.firebaseio.com/"
    }

    @GET("PaymentReminder.json")
    suspend fun getAllHabits(): PaymentsReminderResponse

    @PATCH("PaymentReminder.json")
    suspend fun insertPaymentReminder(@Body habit: PaymentsReminderResponse)

}