package br.com.frazo.dynamic_theme_colors

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.ColorUtils
import kotlin.random.Random

fun randomARGBColor(alpha: Int = 255): Color {
    return Color(Random.nextInt(255), Random.nextInt(255), Random.nextInt(255), alpha)
}

fun randomColorScheme(
    primary: Color = randomARGBColor(),
    onPrimary: Color = randomARGBColor(),
    primaryContainer: Color = randomARGBColor(),
    onPrimaryContainer: Color = randomARGBColor(),
    inversePrimary: Color = randomARGBColor(),
    secondary: Color = randomARGBColor(),
    onSecondary: Color = randomARGBColor(),
    secondaryContainer: Color = randomARGBColor(),
    onSecondaryContainer: Color = randomARGBColor(),
    tertiary: Color = randomARGBColor(),
    onTertiary: Color = randomARGBColor(),
    tertiaryContainer: Color = randomARGBColor(),
    onTertiaryContainer: Color = randomARGBColor(),
    background: Color = randomARGBColor(),
    onBackground: Color = randomARGBColor(),
    surface: Color = randomARGBColor(),
    onSurface: Color = randomARGBColor(),
    surfaceVariant: Color = randomARGBColor(),
    onSurfaceVariant: Color = randomARGBColor(),
    surfaceTint: Color = randomARGBColor(),
    inverseSurface: Color = randomARGBColor(),
    inverseOnSurface: Color = randomARGBColor(),
    error: Color = randomARGBColor(),
    onError: Color = randomARGBColor(),
    errorContainer: Color = randomARGBColor(),
    onErrorContainer: Color = randomARGBColor(),
    outline: Color = randomARGBColor(),
    outlineVariant: Color = randomARGBColor(),
    scrim: Color = randomARGBColor(),
): ColorScheme {
    return ColorScheme(
        primary,
        onPrimary,
        primaryContainer,
        onPrimaryContainer,
        inversePrimary,
        secondary,
        onSecondary,
        secondaryContainer,
        onSecondaryContainer,
        tertiary,
        onTertiary,
        tertiaryContainer,
        onTertiaryContainer,
        background,
        onBackground,
        surface,
        onSurface,
        surfaceVariant,
        onSurfaceVariant,
        surfaceTint,
        inverseSurface,
        inverseOnSurface,
        error,
        onError,
        errorContainer,
        onErrorContainer,
        outline,
        outlineVariant,
        scrim
    )
}

@Composable
fun ColorScheme.blendWithSystemUI(
    darkTheme: Boolean = isSystemInDarkTheme(),
    blendRatio: Float = .5f
): ColorScheme =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        blend(
            anotherColorScheme = if (darkTheme)
                dynamicDarkColorScheme(LocalContext.current)
            else
                dynamicLightColorScheme(LocalContext.current),
            ratio = blendRatio
        )
    } else
        this

fun ColorScheme.blend(anotherColorScheme: ColorScheme, ratio: Float = 0.5f): ColorScheme {
    return ColorScheme(
        primary = Color(
            ColorUtils.blendARGB(
                this.primary.toArgb(),
                anotherColorScheme.primary.toArgb(),
                ratio
            )
        ),
        onPrimary = Color(
            ColorUtils.blendARGB(
                this.onPrimary.toArgb(),
                anotherColorScheme.onPrimary.toArgb(),
                ratio
            )
        ),
        primaryContainer = Color(
            ColorUtils.blendARGB(
                this.primaryContainer.toArgb(),
                anotherColorScheme.primaryContainer.toArgb(),
                ratio
            )
        ),
        onPrimaryContainer = Color(
            ColorUtils.blendARGB(
                this.onPrimaryContainer.toArgb(),
                anotherColorScheme.onPrimaryContainer.toArgb(),
                ratio
            )
        ),
        inversePrimary = Color(
            ColorUtils.blendARGB(
                this.inversePrimary.toArgb(),
                anotherColorScheme.inversePrimary.toArgb(),
                ratio
            )
        ),
        secondary = Color(
            ColorUtils.blendARGB(
                this.secondary.toArgb(),
                anotherColorScheme.secondary.toArgb(),
                ratio
            )
        ),
        onSecondary = Color(
            ColorUtils.blendARGB(
                this.onSecondary.toArgb(),
                anotherColorScheme.onSecondary.toArgb(),
                ratio
            )
        ),
        secondaryContainer = Color(
            ColorUtils.blendARGB(
                this.secondaryContainer.toArgb(),
                anotherColorScheme.secondaryContainer.toArgb(),
                ratio
            )
        ),
        onSecondaryContainer = Color(
            ColorUtils.blendARGB(
                this.onSecondaryContainer.toArgb(),
                anotherColorScheme.onSecondaryContainer.toArgb(),
                ratio
            )
        ),
        tertiary = Color(
            ColorUtils.blendARGB(
                this.tertiary.toArgb(),
                anotherColorScheme.tertiary.toArgb(),
                ratio
            )
        ),
        onTertiary = Color(
            ColorUtils.blendARGB(
                this.onTertiary.toArgb(),
                anotherColorScheme.onTertiary.toArgb(),
                ratio
            )
        ),
        tertiaryContainer = Color(
            ColorUtils.blendARGB(
                this.tertiaryContainer.toArgb(),
                anotherColorScheme.tertiaryContainer.toArgb(),
                ratio
            )
        ),
        onTertiaryContainer = Color(
            ColorUtils.blendARGB(
                this.onTertiaryContainer.toArgb(),
                anotherColorScheme.onTertiaryContainer.toArgb(),
                ratio
            )
        ),
        background = Color(
            ColorUtils.blendARGB(
                this.background.toArgb(),
                anotherColorScheme.background.toArgb(),
                ratio
            )
        ),
        onBackground = Color(
            ColorUtils.blendARGB(
                this.onBackground.toArgb(),
                anotherColorScheme.onBackground.toArgb(),
                ratio
            )
        ),
        surface = Color(
            ColorUtils.blendARGB(
                this.surface.toArgb(),
                anotherColorScheme.surface.toArgb(),
                ratio
            )
        ),
        onSurface = Color(
            ColorUtils.blendARGB(
                this.onSurface.toArgb(),
                anotherColorScheme.onSurface.toArgb(),
                ratio
            )
        ),
        surfaceVariant = Color(
            ColorUtils.blendARGB(
                this.surfaceVariant.toArgb(),
                anotherColorScheme.surfaceVariant.toArgb(),
                ratio
            )
        ),
        onSurfaceVariant = Color(
            ColorUtils.blendARGB(
                this.onSurfaceVariant.toArgb(),
                anotherColorScheme.onSurfaceVariant.toArgb(),
                ratio
            )
        ),
        inverseSurface = Color(
            ColorUtils.blendARGB(
                this.inverseSurface.toArgb(),
                anotherColorScheme.inverseSurface.toArgb(),
                ratio
            )
        ),
        inverseOnSurface = Color(
            ColorUtils.blendARGB(
                this.inverseOnSurface.toArgb(),
                anotherColorScheme.inverseOnSurface.toArgb(),
                ratio
            )
        ),
        outline = Color(
            ColorUtils.blendARGB(
                this.outline.toArgb(),
                anotherColorScheme.outline.toArgb(),
                ratio
            )
        ),
        error = Color(
            ColorUtils.blendARGB(
                this.error.toArgb(),
                anotherColorScheme.error.toArgb(),
                ratio
            )
        ),
        onError = Color(
            ColorUtils.blendARGB(
                this.onError.toArgb(),
                anotherColorScheme.onError.toArgb(),
                ratio
            )
        ),
        errorContainer = Color(
            ColorUtils.blendARGB(
                this.errorContainer.toArgb(),
                anotherColorScheme.errorContainer.toArgb(),
                ratio
            )
        ),
        onErrorContainer = Color(
            ColorUtils.blendARGB(
                this.onErrorContainer.toArgb(),
                anotherColorScheme.onErrorContainer.toArgb(),
                ratio
            )
        ),
        outlineVariant = Color(
            ColorUtils.blendARGB(
                this.outlineVariant.toArgb(),
                anotherColorScheme.outlineVariant.toArgb(),
                ratio
            )
        ),
        scrim = Color(
            ColorUtils.blendARGB(
                this.scrim.toArgb(),
                anotherColorScheme.scrim.toArgb(),
                ratio
            )
        ),
        surfaceTint = Color(
            ColorUtils.blendARGB(
                this.surfaceTint.toArgb(),
                anotherColorScheme.surfaceTint.toArgb(),
                ratio
            )
        ),
    )
}


fun ColorScheme.composite(anotherColorScheme: ColorScheme): ColorScheme {
    return ColorScheme(
        primary = Color(
            ColorUtils.compositeColors(
                this.primary.toArgb(),
                anotherColorScheme.primary.toArgb()
            )
        ),
        onPrimary = Color(
            ColorUtils.compositeColors(
                this.onPrimary.toArgb(),
                anotherColorScheme.onPrimary.toArgb()
            )
        ),
        primaryContainer = Color(
            ColorUtils.compositeColors(
                this.primaryContainer.toArgb(),
                anotherColorScheme.primaryContainer.toArgb()
            )
        ),
        onPrimaryContainer = Color(
            ColorUtils.compositeColors(
                this.onPrimaryContainer.toArgb(),
                anotherColorScheme.onPrimaryContainer.toArgb()
            )
        ),
        inversePrimary = Color(
            ColorUtils.compositeColors(
                this.inversePrimary.toArgb(),
                anotherColorScheme.inversePrimary.toArgb()
            )
        ),
        secondary = Color(
            ColorUtils.compositeColors(
                this.secondary.toArgb(),
                anotherColorScheme.secondary.toArgb()
            )
        ),
        onSecondary = Color(
            ColorUtils.compositeColors(
                this.onSecondary.toArgb(),
                anotherColorScheme.onSecondary.toArgb()
            )
        ),
        secondaryContainer = Color(
            ColorUtils.compositeColors(
                this.secondaryContainer.toArgb(),
                anotherColorScheme.secondaryContainer.toArgb()
            )
        ),
        onSecondaryContainer = Color(
            ColorUtils.compositeColors(
                this.onSecondaryContainer.toArgb(),
                anotherColorScheme.onSecondaryContainer.toArgb()
            )
        ),
        tertiary = Color(
            ColorUtils.compositeColors(
                this.tertiary.toArgb(),
                anotherColorScheme.tertiary.toArgb()
            )
        ),
        onTertiary = Color(
            ColorUtils.compositeColors(
                this.onTertiary.toArgb(),
                anotherColorScheme.onTertiary.toArgb()
            )
        ),
        tertiaryContainer = Color(
            ColorUtils.compositeColors(
                this.tertiaryContainer.toArgb(),
                anotherColorScheme.tertiaryContainer.toArgb()
            )
        ),
        onTertiaryContainer = Color(
            ColorUtils.compositeColors(
                this.onTertiaryContainer.toArgb(),
                anotherColorScheme.onTertiaryContainer.toArgb()
            )
        ),
        background = Color(
            ColorUtils.compositeColors(
                this.background.toArgb(),
                anotherColorScheme.background.toArgb()
            )
        ),
        onBackground = Color(
            ColorUtils.compositeColors(
                this.onBackground.toArgb(),
                anotherColorScheme.onBackground.toArgb()
            )
        ),
        surface = Color(
            ColorUtils.compositeColors(
                this.surface.toArgb(),
                anotherColorScheme.surface.toArgb()
            )
        ),
        onSurface = Color(
            ColorUtils.compositeColors(
                this.onSurface.toArgb(),
                anotherColorScheme.onSurface.toArgb()
            )
        ),
        surfaceVariant = Color(
            ColorUtils.compositeColors(
                this.surfaceVariant.toArgb(),
                anotherColorScheme.surfaceVariant.toArgb()
            )
        ),
        onSurfaceVariant = Color(
            ColorUtils.compositeColors(
                this.onSurfaceVariant.toArgb(),
                anotherColorScheme.onSurfaceVariant.toArgb()
            )
        ),
        inverseSurface = Color(
            ColorUtils.compositeColors(
                this.inverseSurface.toArgb(),
                anotherColorScheme.inverseSurface.toArgb()
            )
        ),
        inverseOnSurface = Color(
            ColorUtils.compositeColors(
                this.inverseOnSurface.toArgb(),
                anotherColorScheme.inverseOnSurface.toArgb()
            )
        ),
        outline = Color(
            ColorUtils.compositeColors(
                this.outline.toArgb(),
                anotherColorScheme.outline.toArgb()
            )
        ),
        error = Color(
            ColorUtils.compositeColors(
                this.error.toArgb(),
                anotherColorScheme.error.toArgb()
            )
        ),
        onError = Color(
            ColorUtils.compositeColors(
                this.onError.toArgb(),
                anotherColorScheme.onError.toArgb()
            )
        ),
        errorContainer = Color(
            ColorUtils.compositeColors(
                this.errorContainer.toArgb(),
                anotherColorScheme.errorContainer.toArgb()
            )
        ),
        onErrorContainer = Color(
            ColorUtils.compositeColors(
                this.onErrorContainer.toArgb(),
                anotherColorScheme.onErrorContainer.toArgb()
            )
        ),
        outlineVariant = Color(
            ColorUtils.compositeColors(
                this.outlineVariant.toArgb(),
                anotherColorScheme.outlineVariant.toArgb()
            )
        ),
        scrim = Color(
            ColorUtils.compositeColors(
                this.scrim.toArgb(),
                anotherColorScheme.scrim.toArgb()
            )
        ),
        surfaceTint = Color(
            ColorUtils.compositeColors(
                this.surfaceTint.toArgb(),
                anotherColorScheme.surfaceTint.toArgb()
            )
        ),
    )
}

@Composable
fun ColorScheme.maskedBy(mask: ColorScheme, maskOpacity: Float): ColorScheme {
    return this.withAlpha(alpha = 1f - maskOpacity)
        .composite(anotherColorScheme = mask.withAlpha(alpha = maskOpacity))
}

@Composable
fun ColorScheme.withAlpha(alpha: Float): ColorScheme {
    return ColorScheme(
        primary = primary.copy(alpha = alpha),
        onPrimary = onPrimary.copy(alpha = alpha),
        primaryContainer = primaryContainer.copy(alpha = alpha),
        onPrimaryContainer = onPrimaryContainer.copy(alpha = alpha),
        inversePrimary = inversePrimary.copy(alpha = alpha),
        secondary = secondary.copy(alpha = alpha),
        onSecondary = onSecondary.copy(alpha = alpha),
        secondaryContainer = secondaryContainer.copy(alpha = alpha),
        onSecondaryContainer = onSecondaryContainer.copy(alpha = alpha),
        tertiary = tertiary.copy(alpha = alpha),
        onTertiary = onTertiary.copy(alpha = alpha),
        tertiaryContainer = tertiaryContainer.copy(alpha = alpha),
        onTertiaryContainer = onTertiaryContainer.copy(alpha = alpha),
        background = background.copy(alpha = alpha),
        onBackground = onBackground.copy(alpha = alpha),
        surface = surface.copy(alpha = alpha),
        onSurface = onSurface.copy(alpha = alpha),
        surfaceVariant = surfaceVariant.copy(alpha = alpha),
        onSurfaceVariant = onSurfaceVariant.copy(alpha = alpha),
        inverseSurface = inverseSurface.copy(alpha = alpha),
        inverseOnSurface = inverseOnSurface.copy(alpha = alpha),
        outline = outline.copy(alpha = alpha),
        error = error.copy(alpha = alpha),
        onError = onError.copy(alpha = alpha),
        errorContainer = errorContainer.copy(alpha = alpha),
        onErrorContainer = onErrorContainer.copy(alpha = alpha),
        outlineVariant = outlineVariant.copy(alpha = alpha),
        scrim = scrim.copy(alpha = alpha),
        surfaceTint = surfaceTint.copy(alpha = alpha)
    )
}