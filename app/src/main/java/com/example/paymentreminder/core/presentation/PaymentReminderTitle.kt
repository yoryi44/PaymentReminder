package com.example.paymentreminder.core.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PaymentReminderTitle(
    title: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = title,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        color = color
    )
}