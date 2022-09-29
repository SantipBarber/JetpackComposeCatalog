package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freelosophy.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

@Composable
fun MyBadgeBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        BadgedBox(
            badge = {
                Badge(
                    backgroundColor = Color.Blue,
                    contentColor = Color.Yellow
                ) {
                    Text("8")
                }
            }
        ) {
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_XL
)
@Composable
fun BadgeBoxPreview() {
    JetpackComposeCatalogTheme {
        Column {
            MyBadgeBox()
        }
    }
}