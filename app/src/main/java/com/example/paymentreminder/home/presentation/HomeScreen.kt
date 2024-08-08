package com.example.paymentreminder.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {

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

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(myItemList.size) { item ->
            Text(text = item.toString())
        }
    }

}