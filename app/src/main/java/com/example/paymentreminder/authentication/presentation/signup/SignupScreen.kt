package com.example.paymentreminder.authentication.presentation.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.paymentreminder.R
import com.example.paymentreminder.authentication.presentation.signup.components.SignupForm
import com.example.paymentreminder.core.presentation.PaymentReminderSubtitle
import com.example.paymentreminder.core.presentation.PaymentReminderTitle
import com.example.paymentreminder.core.presentation.PaymentreminderCircularProgressIndicator

@Composable
fun SignupScreen(
    signupViewModel: SignupViewModel = hiltViewModel(),
    onSignupSuccess: () -> Unit
) {

    val state = signupViewModel.state

    LaunchedEffect(key1 = state.isSignedIn) {
        if(state.isSignedIn)
        {
            onSignupSuccess()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onSecondary)
    ) {
        //FONDO DE PANTALLA LOGIN
        Image(
            painter = painterResource(id = R.drawable.background_signup),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds,
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            PaymentReminderTitle(
                title = stringResource(id = R.string.signup_title),
                color = Color.Black,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            PaymentReminderSubtitle(
                subtitle = stringResource(id = R.string.signup_subtitle),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            SignupForm(state,signupViewModel::onEvent)
        }
    }

    //CIRCULAR PROGRESS INDICATOR
    if(state.isLoading)
    {
        PaymentreminderCircularProgressIndicator()
    }


}