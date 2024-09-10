package com.example.paymentreminder.authentication.presentation.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R
import com.example.paymentreminder.authentication.presentation.login.LoginEvent
import com.example.paymentreminder.authentication.presentation.login.LoginState
import com.example.paymentreminder.core.presentation.PaymentRemainderButton
import com.example.paymentreminder.core.presentation.PaymentReminderTextField

@Composable
fun LoginForm(state: LoginState, onEvent: (LoginEvent) -> Unit) {

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
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
                onValueChange = { onEvent(LoginEvent.EmailChanged(it)) },
                keyboardActions = KeyboardActions(onAny = {
                    focusManager.moveFocus(
                        FocusDirection.Next
                    )
                }),
                keyboardOptions = KeyboardOptions(
                    autoCorrectEnabled = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
            )
            Spacer(modifier = Modifier.size(10.dp))
            PaymentReminderTextField(
                modifier = Modifier.fillMaxWidth(),
                isPassword = true,
                label = stringResource(id = R.string.enter_password),
                value = state.password,
                keyboardType = KeyboardType.Password,
                errorMessaje = if(state.passwordError != null) stringResource(id = state.passwordError.toInt()) else null,
                leadingIcon = Icons.Default.Lock,
                onValueChange = { onEvent(LoginEvent.PasswordChange(it)) },
                keyboardActions = KeyboardActions(onAny = {
                    focusManager.clearFocus()
                }),
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
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