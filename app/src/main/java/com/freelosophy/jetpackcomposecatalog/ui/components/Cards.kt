package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freelosophy.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme


// Card y Surface es lo mismo, así que se pueden usar de manera indiferente

@Composable
fun MyCard(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        contentColor = Color.DarkGray,
        backgroundColor = Color.LightGray,
        border = BorderStroke(1.dp, color = Color.Black)
    ) {
        Column(modifier = Modifier
            .padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 2")
            Text(text = "Ejemplo 3")
            Text(text = "Ejemplo 4")
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_XL
)
@Composable
fun CardPreview() {
    JetpackComposeCatalogTheme {
        Column {
            MyCard()
        }
    }
}