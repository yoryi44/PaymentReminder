package com.example.paymentreminder.authentication.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.authentication.presentation.login.components.LoginForm
import com.example.paymentreminder.core.presentation.PaymentReminderTitle

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onSecondary)
            .padding(20.dp)
    ) {

        PaymentReminderTitle(
            title = "Login",
            color = Color.Black,
            modifier = modifier
                .padding(20.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        LoginForm();
    }

}