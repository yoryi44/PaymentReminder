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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R

@Composable
fun PaymentListItemTitle(
    modifier: Modifier = Modifier,
    amount: Double,
    arrears: Int
) {

    //COLOR OF ITEM LIST AND TITLE
    val backgroundColor: Color
    val title: String

    when {
        arrears < 0 -> {
            backgroundColor = colorResource(R.color.success)
            title = "${stringResource(R.string.days_next_payment)} ${arrears * -1}"
        }

        arrears > 3 -> {
            backgroundColor = colorResource(R.color.danger)
            title = "${stringResource(R.string.arrears)} $arrears"
        }

        else -> {
            backgroundColor = colorResource(R.color.warning)
            title = "${stringResource(R.string.days_next_payment)} $arrears"
        }
    }

    //TITLE OF ITEM LIST
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = backgroundColor)
            .height(40.dp)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$amount",
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.White
        )
        Text(
            text = title,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            color = Color.White
        )
    }
}