package com.example.paymentreminder.paymentsReminder.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R

@Composable
fun PaymentListItemTitle(
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .background(color = colorResource(id = R.color.success))
        .height(40.dp)
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "$20.000",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.White
        )
        Text(
            text = "Dias atrasados: 3",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.White
        )
    }
}