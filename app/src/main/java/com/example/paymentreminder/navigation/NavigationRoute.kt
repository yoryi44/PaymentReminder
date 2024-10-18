package com.example.paymentreminder.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
object Onboarding

@Serializable
object Signup

@Serializable
data class Detail(val paymentReminderId: String?)
