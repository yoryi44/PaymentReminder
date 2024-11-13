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
    if(this.isEmpty()) return "0"
    val format = NumberFormat.getCurrencyInstance(Locale("es", "CO")).apply {
        maximumFractionDigits = 0
    }
    return format.format(this.toDouble())
}

fun String.numberFormatToString(): String {
    return this.replace("[.\$ \u00A0]".toRegex(), "").trim()
}