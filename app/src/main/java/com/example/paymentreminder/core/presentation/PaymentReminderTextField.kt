package com.example.paymentreminder.core.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.paymentreminder.R

@Composable
fun PaymentReminderTextField(
    modifier: Modifier = Modifier,
     isPassword: Boolean = false,
    label: String
) {
    var password by remember { mutableStateOf("") }
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
            value = password,
            onValueChange = { password = it },
            label = { Text(label, color = Color.Gray) },
            placeholder = { if(isPassword) Text("********") },
            visualTransformation = if (!passwordVisibility && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                if(isPassword)
                {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(painterResource(id = passwordVisibilityIcon), contentDescription = null)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium),
                focusedBorderColor = Color.DarkGray
            )
        )
    }
}