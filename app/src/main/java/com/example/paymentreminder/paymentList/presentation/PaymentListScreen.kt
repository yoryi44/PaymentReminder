package com.example.paymentreminder.paymentList.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R
import com.example.paymentreminder.core.presentation.PaymentRemainderDropDwonMenu
import com.example.paymentreminder.core.presentation.PaymentReminderTextField
import com.example.paymentreminder.paymentList.presentation.components.PaymentListItem

@Composable
fun PaymentListScreen(
    modifier: Modifier = Modifier
) {

    val myItemList = listOf(
        "prueba",
        "prueba",
        "prueba",
        "prueba",
        "prueba",
        "prueba",
        "prueba",
        "prueba",
        "prueba",
        "prueba",
    )

    val options = listOf("Option 1", "Option 2", "Option 3")

    Column(modifier = modifier.background(Color.White)) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(colorResource(id = R.color.white)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PaymentReminderTextField(label = stringResource(id = R.string.search), value = "") {}
            PaymentRemainderDropDwonMenu(modifier = modifier, "Filter", options)
        }

        LazyColumn(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(myItemList.size) { item ->
                PaymentListItem(text = item.toString())
            }
        }
    }
}