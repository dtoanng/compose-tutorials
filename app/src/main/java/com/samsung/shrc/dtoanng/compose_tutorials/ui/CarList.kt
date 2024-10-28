package com.samsung.shrc.dtoanng.compose_tutorials.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samsung.shrc.dtoanng.compose_tutorials.model.luxuriousCars
import dev.chrisbanes.haze.haze

@Composable
fun CarList(modifier: Modifier = Modifier, paddingValue: PaddingValues) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            top = paddingValue.calculateTopPadding() + 20.dp,
            bottom = 90.dp
        ),
    ) {
        itemsIndexed(luxuriousCars) { index, car ->
            CarItem(car = car, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}