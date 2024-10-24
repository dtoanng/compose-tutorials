package com.samsung.shrc.dtoanng.compose_tutorials.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDownward
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material.icons.rounded.GridView
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samsung.shrc.dtoanng.compose_tutorials.R
import com.samsung.shrc.dtoanng.compose_tutorials.randomColor

@Composable
fun ActionSection(modifier: Modifier = Modifier) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        ActionItem(
            icon = painterResource(id = R.drawable.money_send),
            name = "Send",
            color = randomColor()
        )

        ActionItem(
            icon = painterResource(id = R.drawable.money_receive),
            name = "Receive",
            color = randomColor()
        )

        ActionItem(
            icon = painterResource(id = R.drawable.see_more),
            name = "More",
            color = randomColor()
        )

    }
}

@Composable
fun ActionItem(
    modifier: Modifier = Modifier, icon: Painter, name: String, color: Color
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.White)
                .background(color = color),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.Black.copy(alpha = 0.7f),
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = name,
            style = TextStyle(
                fontFamily = Font(R.font.sf_ui_display_semibold).toFontFamily(),
                fontSize = 15.sp,
                color = Color.Gray.copy(alpha = 0.9f)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActionSectionPreview() {
    ActionSection(modifier = Modifier.fillMaxWidth())
}