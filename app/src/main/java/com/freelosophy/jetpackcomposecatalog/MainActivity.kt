package com.freelosophy.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.freelosophy.jetpackcomposecatalog.ui.components.MyConfirmationDialog
import com.freelosophy.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var show by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = { show = true}
                        ){
                            Text("Mostrar diálogo")
                        }
                        MyConfirmationDialog(
                            show = show,
                            onDismiss = { show = false },
//                            onConfirm = { Log.i("Alert", "click") }
                        )
                    }
                }
            }
        }
    }
}