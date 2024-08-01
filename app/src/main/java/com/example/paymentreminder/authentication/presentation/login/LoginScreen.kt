package com.example.paymentreminder.authentication.presentation.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.paymentreminder.R
import com.example.paymentreminder.authentication.presentation.login.components.LoginForm
import com.example.paymentreminder.core.presentation.PaymentReminderSubtitle
import com.example.paymentreminder.core.presentation.PaymentReminderTitle

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onSecondary)
    ) {
        //FONDO DE PANTALLA LOGIN
        Image(
            painter = painterResource(id = R.drawable.background_login),
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
                title = "Login",
                color = Color.Black,
                modifier = modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            PaymentReminderSubtitle(
                subtitle = "Your responsabilties is the first",
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth()
            )
            LoginForm();
        }
    }

}