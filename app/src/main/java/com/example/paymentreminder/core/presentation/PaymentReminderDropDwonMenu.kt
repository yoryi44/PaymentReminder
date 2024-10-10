package com.example.paymentreminder.core.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.paymentreminder.R

@Composable
fun PaymentRemainderDropDwonMenu(
    modifier: Modifier = Modifier,
    defaultSelectedOption: String,
    options: List<String>,
    onClick : (String) -> Unit
) {

    var selectedOption by remember { mutableStateOf(defaultSelectedOption) }
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        IconButton(
            onClick = { expanded = true },
            modifier = modifier,
        ) {
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "", tint = Color.Black)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = defaultSelectedOption
                        expanded = false
                        onClick(option)
                    },
//                    leadingIcon = {
//                        Icon(Icons.Default., contentDescription = null)
//                    }
                )
            }
        }
    }

}