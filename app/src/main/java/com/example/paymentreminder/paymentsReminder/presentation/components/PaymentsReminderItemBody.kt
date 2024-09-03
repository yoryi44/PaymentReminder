package com.example.paymentreminder.paymentsReminder.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.paymentsReminder.models.PaymentReminder

@Composable
fun PaymentListItemBody(
    modifier: Modifier = Modifier,
    paymentReminder: PaymentReminder
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White)
    ) {
//        Text(text = paymentReminder.reminderDate, Modifier.weight(0.3f))
        Text(
            text = paymentReminder.notes ?: "",
            Modifier
                .fillMaxWidth()
                .padding(4.dp),
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
    }
}