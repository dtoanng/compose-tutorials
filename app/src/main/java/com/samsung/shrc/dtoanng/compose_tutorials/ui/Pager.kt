package com.samsung.shrc.dtoanng.compose_tutorials.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samsung.shrc.dtoanng.compose_tutorials.R
import com.samsung.shrc.dtoanng.compose_tutorials.ui.theme.Primary

@Composable
fun Pager(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = "Luxurious\nRental Cars",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = Font(R.font.tiltneon).toFontFamily(),
                fontWeight = FontWeight.Black,
                color = Color.White,
                lineHeight = 40.sp,
            )
        )
        Spacer(Modifier.height(10.dp))

        Row {
            Text(
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .weight(1f),
                text = "Luxurious",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Font(R.font.tiltneon).toFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    lineHeight = 40.sp
                )
            )

            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    text = "VIP Cars",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = Font(R.font.tiltneon).toFontFamily(),
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        lineHeight = 40.sp,
                    ),
                )

                Text(
                    modifier = Modifier
                        .alpha(0.7f)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Primary)
                        .padding(horizontal = 5.dp),
                    text = "New",
                    style = TextStyle(
                        fontFamily = Font(R.font.tiltneon).toFontFamily(),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.Bottom) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 3.dp,
                color = MaterialTheme.colorScheme.onBackground
            )
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}