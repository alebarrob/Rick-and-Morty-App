package barrera.alejandro.rickandmortyapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import barrera.alejandro.rickandmortyapp.R

private val fontFamilyLato = FontFamily(
        listOf(
                Font(
                        resId = R.font.lato_regular,
                        weight = FontWeight.Medium
                ),
                Font(
                        resId = R.font.lato_bold,
                        weight = FontWeight.Bold
                )
        )
)

private val fontFamilyCreepster = FontFamily(
        listOf(
                Font(
                        resId = R.font.creepster_regular,
                        weight = FontWeight.Medium
                )
        )
)

val Typography = Typography(
        bodyMedium = TextStyle(
                fontFamily = fontFamilyLato,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
        ),
        labelMedium = TextStyle(
                fontFamily = fontFamilyLato,
                fontSize = 12.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
                shadow = Shadow(
                        color = Black100,
                        offset = Offset(1f, 1f),
                        blurRadius = 1f
                )
        )
)