package com.freelosophy.jetpackcomposecatalog.ui.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SensorDoor
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun CrossfadeAnimation() {
    var myComponentType: ComponentType by remember {
        mutableStateOf(ComponentType.TEXT)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentType() }) {
            Text(text = "Cambiar componente")
        }
        Crossfade(targetState = myComponentType){
            when (it) {
                ComponentType.IMAGE -> Icon(Icons.Default.SensorDoor, contentDescription = "")
                ComponentType.TEXT -> Text(text = "SOY UN COMPONENTE")
                ComponentType.BOX -> Box(
                    Modifier
                        .size(150.dp)
                        .background(Color.Red)
                )
                ComponentType.ERROR -> Text(text = "ERRRRRROOOOOOOOOOOR", color = Color.Red)
            }
        }
    }

}

fun getComponentType(): ComponentType {
    return when(nextInt(from = 0, until = 3)) {
        0 -> ComponentType.IMAGE
        1 -> ComponentType.TEXT
        2 -> ComponentType.BOX
        else -> ComponentType.ERROR
    }
}

enum class ComponentType() {
    IMAGE, TEXT, BOX, ERROR
}