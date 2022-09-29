package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(34.dp),
        maxLines = 1,
        value = myText,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        ),
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }

        },
        label = { Text(text = "Inroduce tu nombre") })
}

@Composable
fun MyNewText() {
    Column(Modifier.fillMaxSize()) {
        Text("Esto es un ejemlo")
        Text("Esto es un ejemlo", color = Color.Blue)
        Text("Esto es un ejemlo", fontWeight = FontWeight.ExtraBold)
        Text("Esto es un ejemlo", fontWeight = FontWeight.Light)
        Text("Esto es un ejemlo", fontFamily = FontFamily.Cursive)
        Text("Esto es un ejemlo", textDecoration = TextDecoration.LineThrough)
        Text("Esto es un ejemlo", textDecoration = TextDecoration.Underline)
        Text(
            "Esto es un ejemlo", textDecoration = TextDecoration.combine(
                listOf(TextDecoration.Underline, TextDecoration.LineThrough)
            )
        )
        Text("Esto es un ejemlo", fontFamily = FontFamily.Cursive, fontSize = 30.sp)
    }
}
