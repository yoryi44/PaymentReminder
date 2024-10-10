package com.example.paymentreminder.authentication.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.paymentreminder.R
import com.example.paymentreminder.authentication.presentation.login.components.LoginForm
import com.example.paymentreminder.core.presentation.PaymentReminderSubtitle
import com.example.paymentreminder.core.presentation.PaymentReminderTitle
import com.example.paymentreminder.core.presentation.PaymentreminderCircularProgressIndicator

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    onLoginSuccess: () -> Unit,
    onCreateAccount: () -> Unit
) {

    val state = loginViewModel.state

    LaunchedEffect(key1 = state.isLoggedIn) {
        if (state.isLoggedIn) {
            onLoginSuccess()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onSecondary)
    ) {
        //FONDO DE PANTALLA LOGIN
        Image(
            painter = painterResource(id = R.mipmap.login_background),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer {
                    alpha = 0.8f
                },
            contentScale = ContentScale.Fit,
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            PaymentReminderTitle(
                title = stringResource(id = R.string.login_title),
                color = Color.Black,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            PaymentReminderSubtitle(
                subtitle = stringResource(id = R.string.login_subtitle),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            LoginForm(state, loginViewModel::onEvent)
            Text(text = buildAnnotatedString{
                append(stringResource(id = R.string.dont_have_an_account))
                append(" ")
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)){
                    append(stringResource(id = R.string.signup))
                }
                },
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .clickable {
                        onCreateAccount()
                    })
        }
    }

    //CIRCULAR PROGRESS INDICATOR
    if (state.isLoading) {
        PaymentreminderCircularProgressIndicator()
    }


}