package com.example.paymentreminder.extensionFunctions

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.toLocalDate(): LocalDate {

    // Define el formato de la fecha
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    // Convierte la cadena a un objeto LocalDate
    return LocalDate.parse(this, formatter)

}