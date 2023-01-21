package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
        topBar = {
            MyTopAppBar(
                onClickIcon = {
                    coroutineScope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Has pulsado el $it")
                    }
                },
                onClickDrawer = { coroutineScope.launch { scaffoldState.drawerState.open() } }
                )
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFab() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = false,
        drawerContent = { MyDrawer() { coroutineScope.launch { scaffoldState.drawerState.close() } } }
    ) {}
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(
        Modifier
            .padding(8.dp)
    ) {
        Text(
            text = "Primera opción",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text = "Segunda opción",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text = "Tercera opción",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
        Text(
            text = "Cuarta opción",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable { onCloseDrawer() }
        )
    }
}

@Composable
fun MyFab() {
    FloatingActionButton(
        onClick = { },
        backgroundColor = Color.Yellow, contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "añadir")
    }
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }
    BottomNavigation(
        backgroundColor = Color.Red,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text("Home") }
        )
        BottomNavigationItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Editar"
                )
            },
            label = { Text("Editar") }
        )
        BottomNavigationItem(
            selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Eliminar"
                )
            },
            label = { Text("Eliminar") }
        )
        BottomNavigationItem(
            selected = index == 3,
            onClick = { index = 3 },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Usuario"
                )
            },
            label = { Text("Usuario") }
        )
    }
}

@Composable
fun MyTopAppBar(
    onClickIcon: (String) -> Unit,
    onClickDrawer: () -> Unit
) {
    TopAppBar(
        title = {
            Text("Mi primera toolbar")
        },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                // onClickIcon("atrás")
                onClickDrawer()
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
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
