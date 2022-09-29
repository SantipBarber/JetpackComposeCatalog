package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MyProgress() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 8.dp,
                modifier = Modifier
                    .size(64.dp)
            )
            LinearProgressIndicator(
                modifier = Modifier
                    .padding(top = 32.dp),
                backgroundColor = Color.Green,
                color = Color.White
            )
        }
        Button(onClick = {
            showLoading = !showLoading
        }){
            Text(text = "Cargar Perfil")
        }
    }
}


@Composable
fun MyProgressAdvance() {
    var progressStatus by remember { mutableStateOf(0.5f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            progress = progressStatus
        )
        Row(Modifier.fillMaxWidth()){
            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                onClick = { progressStatus += 0.1f  }
            ) {
                Text(text = "Incrementar")
            }
            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                onClick = { progressStatus -= 0.1f }
            ) {
                Text(text = "Reducir")
            }
        }
    }
}
