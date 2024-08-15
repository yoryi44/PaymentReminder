package com.example.paymentreminder.core.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.paymentreminder.R

@Composable
fun PaymentReminderTextField(
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    label: String,
    value: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    errorMessaje : String? = null,
    leadingIcon: ImageVector,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    val passwordVisibilityIcon: Int = if (passwordVisibility) {
        R.drawable.ic_lock_open
    } else {
        R.drawable.ic_lock
    }

    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = modifier,
            label = { Text(label, color = Color.Gray) },
            placeholder = { if(isPassword) Text("********") },
            leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = "leadingIcon")},
            keyboardOptions = keyboardOptions,
            visualTransformation = if (!passwordVisibility && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardActions = keyboardActions,
            trailingIcon = {
                if(isPassword)
                {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(painterResource(id = passwordVisibilityIcon), contentDescription = null)
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                focusedBorderColor = Color.DarkGray
            ),
        )
        if(errorMessaje != null){
            Text(text = errorMessaje, color = Color.Red)
        }
    }
}