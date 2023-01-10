package com.freelosophy.jetpackcomposecatalog.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.freelosophy.jetpackcomposecatalog.model.Routes

@Composable
fun Screen1(navigationController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Yellow)) {
        Text(
            text = "Pantalla 1",
            modifier = Modifier.align(Alignment.Center)
                .clickable { navigationController.navigate(Routes.Screen2.route) }
        )
    }
}

@Composable
fun Screen2(navigationController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
        Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center).clickable {
            navigationController.navigate(Routes.Screen3.route)
        }
        )
    }
}

@Composable
fun Screen3(navigationController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center).clickable {
            navigationController.navigate(Routes.Screen4.createRoute(42))
        }
        )
    }
}

@Composable
fun Screen4(navigationController: NavHostController, age: Int) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Cyan)) {
        Text(text = "Tengo $age años", modifier = Modifier.align(Alignment.Center).clickable {
            navigationController.navigate(Routes.Screen5.createRoute("Santi"))
        }
        )
    }
}

@Composable
fun Screen5(navigationController: NavHostController, name: String?) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Gray)) {
        Text(text = "Me llamo $name", modifier = Modifier.align(Alignment.Center).clickable {
            navigationController.navigate(Routes.Screen1.route)
        }
        )
    }
}