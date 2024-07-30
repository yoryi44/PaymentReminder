package com.example.paymentreminder.authentication.presentation.login.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.core.presentation.PaymentReminderTextField

@Composable
fun LoginForm() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(
                BorderStroke(2.dp, Color.LightGray),
                shape = RoundedCornerShape(20.dp)
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        PaymentReminderTextField()
        PaymentReminderTextField()
    }
}