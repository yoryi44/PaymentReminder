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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.extensionFunctions.toNumberFormat

@Composable
fun PaymentListItemTitle(
    modifier: Modifier = Modifier,
    amount: String,
    arrears: Int,
    color: Color,
    title: Int
) {

    //TITLE OF ITEM LIST
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = color)
            .height(40.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = amount.toNumberFormat(),
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.White
        )
        Text(
            text = stringResource(id = title) + " $arrears",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.White
        )
    }
}