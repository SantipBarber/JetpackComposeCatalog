package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyButtonExample() {
    var enabled by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            enabled = enabled,
            border = BorderStroke(5.dp, color = Color.Green),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            onClick = { enabled = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Púlsame")
        }
        OutlinedButton(
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            modifier = Modifier.padding(top = 8.dp),
            onClick = { enabled = false }
        ) {
            Text(text = "Hola")
        }
        TextButton(
            onClick = {}
        ) {
            Text("Hola")
        }
    }
}

@Composable
fun MySwitch() {
    var state by remember { mutableStateOf(false) }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta,
            uncheckedTrackAlpha = 0.5f,
            checkedTrackAlpha = 0.5f,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Yellow
        )
    )
}
