package com.samsung.shrc.dtoanng.compose_tutorials.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen4(onGoBack: () -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Yellow.copy(alpha = 0.2f)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Screen 4",
            fontSize = 24.sp
        )
        
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { onGoBack() }) {
            Text(text = "Go to Home screen (Screen 1)", fontSize = 18.sp)
        }
    }
}