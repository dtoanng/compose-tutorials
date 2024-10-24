package com.samsung.shrc.dtoanng.compose_tutorials.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samsung.shrc.dtoanng.compose_tutorials.R

@Composable
fun CardSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 38.dp, vertical = 5.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color.Blue.copy(alpha = 0.6f), Color.Cyan.copy(alpha = 0.6f))
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 10.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color.Green.copy(alpha = 0.8f), Color.Yellow.copy(alpha = 0.8f))
                    ),
                ),
        )

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp, vertical = 15.dp)
                .height(220.dp)
                .clip(RoundedCornerShape(20.dp)),
            elevation = CardDefaults.cardElevation(6.dp),
        ) {
            CardContent(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun CardContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(
            brush = Brush.linearGradient(
                listOf(
                    MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.error
                )
            )
        )
    ) {
        Icon(
            painter = painterResource(
                id = R.drawable.global
            ),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background.copy(alpha = 0.1f),
            modifier = Modifier
                .fillMaxSize()
                .offset(100.dp, 60.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "My balance", color = MaterialTheme.colorScheme.onPrimary.copy(0.6f), style = TextStyle(
                    fontFamily = Font(R.font.sf_ui_display_thin).toFontFamily(),
                    fontSize = 20.sp,
                ), textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "$4.453.00", color = MaterialTheme.colorScheme.onPrimary.copy(0.9f), style = TextStyle(
                    fontFamily = Font(R.font.sf_ui_display_heavy).toFontFamily(),
                    fontSize = 30.sp,
                ), textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "**** **** *456", color = MaterialTheme.colorScheme.onPrimary.copy(0.9f), style = TextStyle(
                    fontFamily = Font(R.font.sf_ui_display_bold).toFontFamily(),
                    fontSize = 16.sp,
                ), textAlign = TextAlign.Center
            )

            Icon(
                painter = painterResource(id = R.drawable.visa),
                contentDescription = null,
                modifier = Modifier.width(45.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun CardSectionPreview() {
    CardSection(modifier = Modifier.fillMaxWidth())
}