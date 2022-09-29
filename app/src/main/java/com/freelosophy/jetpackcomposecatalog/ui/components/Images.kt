package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.freelosophy.jetpackcomposecatalog.R

@Composable
fun MyIcon() {
    // https://fonts.google.com/icons
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icono",
        tint = Color.Red
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "",
        modifier = Modifier
//            .clip(RoundedCornerShape(25f))
            .clip(CircleShape)
            .border(width = 5.dp, color = Color.Red, shape = CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "",
        alpha = 0.5f
    )
}