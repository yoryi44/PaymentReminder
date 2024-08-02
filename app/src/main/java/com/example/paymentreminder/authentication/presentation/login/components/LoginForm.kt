package com.example.paymentreminder.authentication.presentation.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R
import com.example.paymentreminder.authentication.presentation.login.LoginEvent
import com.example.paymentreminder.authentication.presentation.login.LoginState
import com.example.paymentreminder.core.presentation.PaymentRemainderButton
import com.example.paymentreminder.core.presentation.PaymentReminderTextField

@Composable
fun LoginForm(state: LoginState, onEvent: (LoginEvent) -> Unit) {

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
                onValueChange = { onEvent(LoginEvent.EmailChanged(it)) }
            )
            Spacer(modifier = Modifier.size(10.dp))
            PaymentReminderTextField(
                modifier = Modifier.fillMaxWidth(),
                isPassword = true,
                label = stringResource(id = R.string.enter_password),
                value = state.password,
                keyboardType = KeyboardType.Password,
                errorMessaje = state.passwordError,
                onValueChange = { onEvent(LoginEvent.PasswordChange(it)) }
            )
            Spacer(modifier = Modifier.size(10.dp))
            PaymentRemainderButton(
                onClick = {onEvent(LoginEvent.Login)}, modifier = Modifier.fillMaxWidth(), text = stringResource(
                    id = R.string.login_title
                )
            )
        }
    }
}