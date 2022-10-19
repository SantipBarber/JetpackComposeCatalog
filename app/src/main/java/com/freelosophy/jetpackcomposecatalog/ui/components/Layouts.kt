package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freelosophy.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme


@Composable
fun MySpacer(size: Int){
    Spacer(modifier = Modifier.fillMaxWidth().height(size.dp))
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth().weight(1f).background(Color.Cyan)) {
            Text("Ejemplo 1", modifier = Modifier.align(Alignment.Center))
        }
        MySpacer(10)
        Row(modifier = Modifier.fillMaxWidth().weight(1f)) {
            Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Red)) {
                Text("Ejemplo 2", modifier = Modifier.align(Alignment.Center))
            }
            Box(modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Green)) {
                Text("Ejemplo 3", modifier = Modifier.align(Alignment.Center))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
                .padding(12.dp)
        ) {
            Text("Ejemplo 3", modifier = Modifier.align(Alignment.TopCenter))
            Text("Ejemplo 4", modifier = Modifier.align(Alignment.Center))
            Text("Ejemplo 5", modifier = Modifier.align(Alignment.BottomCenter))
            Text("Ejemplo 6", modifier = Modifier.align(Alignment.CenterStart))
            Text("Ejemplo 7", modifier = Modifier.align(Alignment.CenterEnd))
        }
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text("Esto es un ejemplo 1", modifier = Modifier.background(Color.Cyan))
        Text("Esto es un ejemplo 2", modifier = Modifier.background(Color.Yellow))
        Text("Esto es un ejemplo 3", modifier = Modifier.background(Color.Red))
        Text("Esto es un ejemplo 4", modifier = Modifier.background(Color.Blue))

    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text("Esto es un ejemplo 1", modifier = Modifier.background(Color.Cyan))
        Text("Esto es un ejemplo 2", modifier = Modifier.background(Color.Yellow))
        Text("Esto es un ejemplo 3", modifier = Modifier.background(Color.Red))
        Text("Esto es un ejemplo 4", modifier = Modifier.background(Color.Blue))

    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(Color.Cyan)
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_XL
)
@Composable
fun MyLayoutPreview() {
    JetpackComposeCatalogTheme {
        Column {
            MyRow()
        }
    }
}