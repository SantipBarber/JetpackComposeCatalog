package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.RangeSlider
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freelosophy.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme
import kotlin.math.roundToInt


@Composable
fun MyBasicSlider(){
    var sliderPosition by remember { mutableStateOf(0f) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyRangeSlider() {
    var currentRange by remember { mutableStateOf(0f..100f) }
    Column(
        modifier = Modifier.padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RangeSlider(
            values = currentRange,
            onValueChange = { currentRange = it },
            valueRange = 0f..100f,
            steps = 9
        )
        Text(text = "Valor inferior ${currentRange.start.roundToInt()}")
        Text(text = "Valor superior ${currentRange.endInclusive.roundToInt()}")
    }
}

@Composable
fun MyAdvancedSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    var completeValue by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toInt() },
            valueRange = 0f..100f,
            steps = 9
        )
        Text(text = completeValue.toString())
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_XL
)
@Composable
fun MySlidersPreview() {
    JetpackComposeCatalogTheme {
        Column {
            MyRangeSlider()
        }
    }
}