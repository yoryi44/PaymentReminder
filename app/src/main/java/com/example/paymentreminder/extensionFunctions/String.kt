package com.example.paymentreminder.extensionFunctions

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun String.toLocalDate(): LocalDate {

    // Define el formato de la fecha
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    // Convierte la cadena a un objeto LocalDate
    return LocalDate.parse(this, formatter)

}