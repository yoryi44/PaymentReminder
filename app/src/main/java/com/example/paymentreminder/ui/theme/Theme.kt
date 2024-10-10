package com.example.paymentreminder.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Blue200,
    secondary = Blue700,
    tertiary = Blue500,
    background = Blue900,
    onPrimary = Blue900,
    onSecondary = White,
    onBackground = White,
    onTertiary = Blue900,
    surface = Blue900,
    onSurface = Blue200
)

private val LightColorScheme = lightColorScheme(

    primary = Blue500,
    secondary = Blue200,
    tertiary = Blue700,
    background = Blue50,
    onPrimary = White,
    onSecondary = Blue900,
    onBackground = Blue900,
    onTertiary = White,
    surface = Blue50,
    onSurface = Blue900,
)

@Composable
fun PaymentReminderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}