package com.workshipflow.app.core.ui

import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

private val DarkColorScheme = darkColorScheme(
    primary = VividPrimaryDark,
    onPrimary = VividOnPrimaryDark,
    primaryContainer = VividPrimaryContainerDark,
    onPrimaryContainer = VividOnPrimaryContainerDark,
    secondary = VividSecondaryDark,
    onSecondary = VividOnSecondaryDark,
    secondaryContainer = VividSecondaryContainerDark,
    onSecondaryContainer = VividOnSecondaryContainerDark,
    tertiary = VividTertiaryDark,
    onTertiary = VividOnTertiaryDark,
    tertiaryContainer = VividTertiaryContainerDark,
    onTertiaryContainer = VividOnTertiaryContainerDark,
    error = VividErrorDark,
    onError = VividOnErrorDark,
    errorContainer = VividErrorContainerDark,
    onErrorContainer = VividOnErrorContainerDark,
    background = VividSurfaceDark,
    onBackground = VividOnSurfaceDark,
    surface = VividSurfaceDark,
    onSurface = VividOnSurfaceDark,
    surfaceVariant = VividSurfaceVariantDark,
    onSurfaceVariant = VividOnSurfaceVariantDark,
    outline = VividOutlineDark,
    outlineVariant = VividOutlineVariantDark,
    surfaceDim = VividSurfaceDimDark,
    surfaceBright = VividSurfaceBrightDark,
    surfaceContainerLowest = VividSurfaceContainerLowestDark,
    surfaceContainerLow = VividSurfaceContainerLowDark,
    surfaceContainer = VividSurfaceContainerDarkScheme,
    surfaceContainerHigh = VividSurfaceContainerHighDark,
    surfaceContainerHighest = VividSurfaceContainerHighestDark
)

private val LightColorScheme = lightColorScheme(
    primary = VividPrimary,
    onPrimary = VividOnPrimary,
    primaryContainer = VividPrimaryContainer,
    onPrimaryContainer = VividOnPrimaryContainer,
    secondary = VividSecondary,
    onSecondary = VividOnSecondary,
    secondaryContainer = VividSecondaryContainer,
    onSecondaryContainer = VividOnSecondaryContainer,
    tertiary = VividTertiary,
    onTertiary = VividOnTertiary,
    tertiaryContainer = VividTertiaryContainer,
    onTertiaryContainer = VividOnTertiaryContainer,
    error = VividError,
    onError = VividOnError,
    errorContainer = VividErrorContainer,
    onErrorContainer = VividOnErrorContainer,
    background = VividSurface,
    onBackground = VividOnSurface,
    surface = VividSurface,
    onSurface = VividOnSurface,
    surfaceVariant = VividSurfaceVariant,
    onSurfaceVariant = VividOnSurfaceVariant,
    outline = VividOutline,
    outlineVariant = VividOutlineVariant,
    surfaceDim = VividSurfaceDim,
    surfaceBright = VividSurfaceBright,
    surfaceContainerLowest = VividSurfaceContainerLowest,
    surfaceContainerLow = VividSurfaceContainerLow,
    surfaceContainer = VividSurfaceContainer,
    surfaceContainerHigh = VividSurfaceContainerHigh,
    surfaceContainerHighest = VividSurfaceContainerHighest
)

@Composable
fun WorkshipflowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Set to false to prioritize brand identity
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

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun WorkshipflowThemePreview() {
    WorkshipflowTheme {
        Surface {
            Text(text = "Workshipflow Theme")
        }
    }
}
