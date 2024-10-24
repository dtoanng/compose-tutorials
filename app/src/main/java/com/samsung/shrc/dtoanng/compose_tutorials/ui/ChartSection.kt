package com.samsung.shrc.dtoanng.compose_tutorials.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samsung.shrc.dtoanng.compose_tutorials.randomColor
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

@Composable
fun ChartSection(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(start = 22.dp)
    ) {
        SubTitle(subtitle = "Spending Statistics")
        Chart()
    }

}

@Composable
fun Chart(modifier: Modifier = Modifier) {
    BarChart(
        modifier = modifier,
        barChartData = BarChartData(spendingByDay),
        xAxisDrawer = SimpleXAxisDrawer(
            axisLineThickness = 2.dp,
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
        ),
        yAxisDrawer = SimpleYAxisDrawer(
            axisLineThickness = 2.dp,
            labelValueFormatter = { "$${it.toInt()}" },
            axisLineColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f),
            labelTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
        ),
        labelDrawer = SimpleLabelDrawer(
            drawLocation = SimpleLabelDrawer.DrawLocation.Outside,
            labelTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ChartSectionPreview() {
    ChartSection()
}

val spendingByDay = listOf(
    BarChartData.Bar(
        label = "Dec 1",
        value = 132f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 2",
        value = 0f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 3",
        value = 0f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 4",
        value = 170f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 5",
        value = 120f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 6",
        value = 132f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 7",
        value = 50f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 8",
        value = 90f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 9",
        value = 112f,
        color = randomColor(60)
    ),
    BarChartData.Bar(
        label = "Dec 10",
        value = 140f,
        color = randomColor(60)
    )
)