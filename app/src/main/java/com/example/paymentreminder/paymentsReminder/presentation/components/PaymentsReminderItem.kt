package com.example.paymentreminder.paymentsReminder.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.paymentsReminder.presentation.models.PaymentReminder

@Composable
fun PaymentsReminderItem(
    modifier: Modifier = Modifier,
    paymentReminder: PaymentReminder,
    onClick : () -> Unit
) {

    //ITEM LIST
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.White)
            .clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        PaymentListItemTitle(amount = paymentReminder.amount, arrears = paymentReminder.arrears)
        PaymentListItemBody(paymentReminder = paymentReminder)
    }
}