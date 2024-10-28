package com.samsung.shrc.dtoanng.compose_tutorials.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samsung.shrc.dtoanng.compose_tutorials.R

@Composable
fun BottomBar(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .padding(vertical = 10.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        bottomBarItems.forEach { item ->
            Item(bottomBarItem = item)
        }
    }

}

@Composable
fun Item(modifier: Modifier = Modifier, bottomBarItem: BottomBarItem) {
    Column(
        modifier = Modifier
            .background(
                color = if (bottomBarItem.isSelected) Color.Gray.copy(alpha = 0.4f) else Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = bottomBarItem.icon), contentDescription = bottomBarItem.title, modifier = Modifier.size(30.dp))
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = bottomBarItem.title,
            style = TextStyle(
                fontFamily = Font(R.font.tiltneon).toFontFamily(),
                fontSize = 12.sp,
                color = Color.White,
            ),
            maxLines = 1
        )
    }
}


@Preview
@Composable
fun BottomBarPreview() {
    BottomBar()
}

data class BottomBarItem(
    val title: String,
    val icon: Int,
    val isSelected: Boolean
)

val bottomBarItems = listOf(
    BottomBarItem(
        title = "Home",
        icon = R.drawable.home,
        isSelected = true
    ),

    BottomBarItem(
        title = "Account",
        icon = R.drawable.account_avatar,
        isSelected = false
    ),

    BottomBarItem(
        title = "Analytics",
        icon = R.drawable.analytics,
        isSelected = false
    ),

    BottomBarItem(
        title = "Settings",
        icon = R.drawable.settings,
        isSelected = false
    ),
)