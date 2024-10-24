package com.samsung.shrc.dtoanng.compose_tutorials.ui

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.samsung.shrc.dtoanng.compose_tutorials.randomColor

@Composable
fun SpendingSection(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 22.dp)
    ) {
        SubTitle(subtitle = "Spending Breakdown")
        LazyRow(modifier = Modifier.fillMaxWidth(), userScrollEnabled = true) {
            items(spendingList) { item ->
                SpendingItemSection(spendingItem = item)
            }
        }
    }

}

@Composable
fun SpendingItemSection(modifier: Modifier = Modifier, spendingItem: SpendingItem) {
    ElevatedCard(
        modifier = modifier
            .size(150.dp, 120.dp)
            .padding(end = 15.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .background(color = spendingItem.color)
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                modifier = Modifier
                    .size(20.dp),
                painter = painterResource(id = spendingItem.icon),
                tint = Color.Black.copy(alpha = 0.8f),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = spendingItem.name,
                style = TextStyle(
                    fontFamily = Font(R.font.sf_ui_display_semibold).toFontFamily(),
                    fontSize = 12.sp,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            )

            Text(
                modifier = Modifier,
                text = "$${spendingItem.amount}",
                style = TextStyle(
                    fontFamily = Font(R.font.sf_ui_display_bold).toFontFamily(),
                    fontSize = 20.sp,
                    color = Color.Black.copy(alpha = 0.7f)
                ),
                textAlign = TextAlign.Left,
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpendingSectionPreview() {
    SpendingSection()
}

data class SpendingItem(val name: String, val amount: Float, val color: Color, val icon: Int)

val spendingList = mutableListOf(
    SpendingItem(name = "Shopping", amount = 166f, color = randomColor(), icon = R.drawable.shopping_cart),
    SpendingItem(name = "Health", amount = 109f, color = randomColor(), icon = R.drawable.health),
    SpendingItem(name = "Travel", amount = 500f, color = randomColor(), icon = R.drawable.flight_ticket),
    SpendingItem(name = "Subscription", amount = 140f, color = randomColor(), icon = R.drawable.album),
)