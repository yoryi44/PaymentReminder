package com.example.paymentreminder.authentication.presentation.signup.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R
import com.example.paymentreminder.authentication.presentation.signup.SignupEvent
import com.example.paymentreminder.authentication.presentation.signup.SignupState
import com.example.paymentreminder.core.presentation.PaymentRemainderButton
import com.example.paymentreminder.core.presentation.PaymentReminderTextField

@Composable
fun SignupForm(state: SignupState, onEvent: (SignupEvent) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            PaymentReminderTextField(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.enter_email),
                value = state.email,
                keyboardType = KeyboardType.Email,
                errorMessaje = state.emailError,
                leadingIcon = Icons.Default.Email,
                onValueChange = { onEvent(SignupEvent.EmailChanged(it)) }
            )
            Spacer(modifier = Modifier.size(10.dp))
            PaymentReminderTextField(
                modifier = Modifier.fillMaxWidth(),
                isPassword = true,
                label = stringResource(id = R.string.enter_password),
                value = state.password,
                keyboardType = KeyboardType.Password,
                errorMessaje = if (state.passwordError != null) stringResource(id = state.passwordError.toInt()) else null,
                leadingIcon = Icons.Default.Lock,
                onValueChange = { onEvent(SignupEvent.PasswordChange(it)) }
            )
            Spacer(modifier = Modifier.size(10.dp))
            PaymentRemainderButton(
                onClick = { onEvent(SignupEvent.Signup) },
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(
                    id = R.string.signup_title
                )
            )
        }
    }
}