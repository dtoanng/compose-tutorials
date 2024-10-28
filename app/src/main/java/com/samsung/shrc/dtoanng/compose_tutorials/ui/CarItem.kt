package com.samsung.shrc.dtoanng.compose_tutorials.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samsung.shrc.dtoanng.compose_tutorials.R
import com.samsung.shrc.dtoanng.compose_tutorials.model.Car
import com.samsung.shrc.dtoanng.compose_tutorials.ui.theme.Secondary

@Composable
fun CarItem(
    modifier: Modifier = Modifier,
    car: Car
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(car.bgColor.copy(alpha = 0.8f), Color.White)
                ),
            )
    ) {

        Image(
            painter = painterResource(id = car.image),
            contentDescription = null,
            modifier = Modifier.offset(x = 150.dp, y = 0.dp)
        )

        Column(modifier = Modifier.fillMaxSize()) {
            CarInfo(car = car)
            Spacer(modifier = Modifier.size(10.dp))
            Rating(car = car)
            Spacer(modifier = Modifier.size(10.dp))
            BuyButton(car = car)
        }
    }
}

@Composable
fun CarInfo(modifier: Modifier = Modifier, car: Car) {
    Row(
        modifier = Modifier.padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = MaterialTheme.colorScheme.onBackground)
                .padding(6.dp)
                .size(40.dp),
            painter = painterResource(id = car.logo),
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column {

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Color:",
                    style = TextStyle(
                        fontFamily = Font(R.font.tiltneon).toFontFamily(),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black.copy(alpha = 0.7f)
                    )
                )

                Spacer(modifier = Modifier.width(5.dp))

                Box(
                    modifier = Modifier
                        .background(color = car.color, shape = CircleShape)
                        .size(10.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = car.name, style = TextStyle(
                    fontFamily = Font(R.font.tiltneon).toFontFamily(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black.copy(alpha = 0.7f)
                )
            )
        }
    }
}

@Composable
fun Rating(modifier: Modifier = Modifier, car: Car) {
    Column(modifier = modifier.padding(start = 20.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box {
                car.recommenders.forEachIndexed { index, item ->
                    Rater(
                        image = item,
                        modifier = Modifier.padding(start = if (index == 0) 0.dp else (index * 24).dp)
                    )
                }
            }

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = car.recommendationRate.toString(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = Font(R.font.tiltneon).toFontFamily(),
                    fontWeight = FontWeight.SemiBold
                )
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "${car.recommendation}% Recommended",
            style = TextStyle(
                fontFamily = Font(R.font.tiltneon).toFontFamily(),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
            )
        )
    }
}

@Composable
fun Rater(modifier: Modifier = Modifier, image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = modifier
            .size(30.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.Black, shape = CircleShape)
    )
}

@Composable
fun BuyButton(modifier: Modifier = Modifier, car: Car) {
    Row(
        modifier = Modifier
            .padding(start = 20.dp)
            .background(color = car.bgColor, shape = RoundedCornerShape(20.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${car.rentalDays} Days", style = TextStyle(
                fontSize = 14.sp,
                fontFamily = Font(R.font.tiltneon).toFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "$${car.price}.00", style = TextStyle(
                fontSize = 20.sp,
                fontFamily = Font(R.font.tiltneon).toFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        )

        Spacer(modifier = Modifier.width(10.dp))

        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = null
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CarItemPreview() {
    CarItem(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        car = Car(
            name = "Ferrari SF90 Stradale",
            image = R.drawable.ferrari_car,
            color = Color.Red,
            logo = R.drawable.ferrari_logo,
            recommendation = 98,
            recommendationRate = 4.9f,
            rentalDays = 7,
            price = 789,
            recommenders = listOf(
                R.drawable.m_1, R.drawable.w_2, R.drawable.m_3
            ),
            bgColor = Secondary
        )
    )
}