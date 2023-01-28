package com.freelosophy.jetpackcomposecatalog.ui.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ColorAnimationAdvanced() {
    Column() {
        var firstColor by rememberSaveable { mutableStateOf(false) }
        var showBox by rememberSaveable { mutableStateOf(true) }
        val realColor by animateColorAsState(
            targetValue = if (firstColor) Color.Red else Color.Magenta,
            animationSpec = tween(3_000),
            finishedListener = { showBox = false }
        )
        if (showBox){
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(realColor)
                    .clickable { firstColor = !firstColor }
            )
        }
    }
}