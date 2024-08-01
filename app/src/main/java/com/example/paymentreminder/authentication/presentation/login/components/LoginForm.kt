package com.example.paymentreminder.authentication.presentation.login.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R
import com.example.paymentreminder.core.presentation.PaymentRemainderButton
import com.example.paymentreminder.core.presentation.PaymentReminderTextField

@Composable
fun LoginForm() {

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
                label = stringResource(id = R.string.enter_email)
            )
            Spacer(modifier = Modifier.size(10.dp))
            PaymentReminderTextField(
                modifier = Modifier.fillMaxWidth(),
                isPassword = true,
                label = stringResource(id = R.string.enter_password)
            )
            Spacer(modifier = Modifier.size(10.dp))
            PaymentRemainderButton(
                onClick = {}, modifier = Modifier.fillMaxWidth(), text = stringResource(
                    id = R.string.login_title
                )
            )
        }
    }
}