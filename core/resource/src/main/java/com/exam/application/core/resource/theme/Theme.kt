package com.exam.application.core.resource.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = colorLightBackgroundPrimary,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = colorLightBackgroundDefault,
    onBackground = colorLightBackgroundPrimary,
    surface = colorLightBackgroundSurface,
    onSecondaryContainer = colorLightBorderDefault,
    onPrimary = colorLightContentDefault,
    onPrimaryContainer = colorLightContentDefault,
    onSecondary = colorLightContentSecondary,
    onTertiary = colorLightContentLinkPrimary
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}