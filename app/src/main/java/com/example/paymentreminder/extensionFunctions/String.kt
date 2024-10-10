package com.example.paymentreminder.extensionFunctions

import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.toLocalDate(): LocalDate {

    // Define el formato de la fecha
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    // Convierte la cadena a un objeto LocalDate
    return LocalDate.parse(this, formatter)

}

fun String.toNumberFormat(): String {
    val format = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
    return format.format(this.toDouble())
}