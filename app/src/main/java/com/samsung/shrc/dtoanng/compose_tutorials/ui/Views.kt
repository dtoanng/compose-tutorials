package com.samsung.shrc.dtoanng.compose_tutorials.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samsung.shrc.dtoanng.compose_tutorials.R

@Composable
fun SubTitle(modifier: Modifier = Modifier, subtitle: String) {
    Text(
        modifier = Modifier.padding(vertical = 20.dp),
        text = subtitle,
        style = TextStyle(
            fontFamily = Font(R.font.sf_ui_display_semibold).toFontFamily(),
            fontSize = 25.sp,
            color = Color.Gray.copy(alpha = 0.9f)
        ),
        fontWeight = FontWeight.Medium
    )
}