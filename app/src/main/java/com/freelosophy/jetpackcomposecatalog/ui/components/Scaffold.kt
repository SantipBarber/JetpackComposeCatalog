package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = { MyTopAppBar {
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Has pulsado el $it")
            }
        }
        },
        scaffoldState = scaffoldState
    ) {}
}


@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = {
            Text("Mi primera toolbar")
        },
        backgroundColor = Color.Red,
        contentColor = Color.Black,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("atrás") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "buscar")
            }
            IconButton(onClick = { onClickIcon("favorito") }) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = "back")
            }
        }
    )
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL
)
@Composable
fun MyScaffold() {
    ScaffoldExample()
}
