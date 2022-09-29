package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.freelosophy.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = {
                //Acciones si se pulsa fuera del diálogo
                onDismiss()
            },
            title = { Text("Título") },
            text = { Text("Hola, soy una descripción super guay!") },
            confirmButton = {
                TextButton(
                    onClick = { onConfirm() },
                ) {
                    Text("ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text("DismissButton")
                }
            }
        )
    }
}

//@Preview(
//    showBackground = true,
//    showSystemUi = true,
//    device = Devices.PIXEL_XL
//)
//@Composable
//fun MyDialogPreview() {
//    JetpackComposeCatalogTheme {
//        Column {
//            MyAlertDialog(true)
//        }
//    }
//}