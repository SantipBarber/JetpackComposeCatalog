package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.freelosophy.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
//    onConfirm: () -> Unit
) {
    var status by remember { mutableStateOf("") }
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() }
        ) {
            Card(shape = MaterialTheme.shapes.small) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                ) {

                    MyTitleDialog(
                        title = "Phone Ringtone",
                        modifier = Modifier
                            .padding(24.dp)
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.LightGray
                    )
                    MyRadioButtonList(
                        name = status, modifier = Modifier
                            .padding(6.dp)
                    ) { status = it }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.LightGray
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(8.dp)
                    ) {
                        TextButton(onClick = { }) { Text(text = "CANCEL") }
                        TextButton(onClick = { }) { Text(text = "OK") }
                    }
                }
            }
        }
    }
}

/**
 * Para el MyAlertDialog
 */
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            JetpackComposeCatalogTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
////                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    var show by remember { mutableStateOf(false) }
//                    Box(
//                        modifier = Modifier.fillMaxSize(),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Button(
//                            onClick = { show = true}
//                        ){
//                            Text("Mostrar diálogo")
//                        }
//                        MyAlertDialog(
//                            show = show,
//                            onDismiss = { show = false },
//                            onConfirm = { Log.i("Alert", "click") }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}


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

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo")
                Text(text = "Esto es un ejemplo")
                Text(text = "Esto es un ejemplo")
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(
                    "Set backup account", Modifier
                        .padding(12.dp)
                )
                AccountItem(
                    email = "ejemplo1@gmail.com",
                    drawable = com.freelosophy.jetpackcomposecatalog.R.drawable.avatar
                )
                AccountItem(
                    email = "ejemplo2@gmail.com",
                    drawable = com.freelosophy.jetpackcomposecatalog.R.drawable.avatar
                )
                AccountItem(
                    email = "Añadir una nueva cuenta",
                    drawable = com.freelosophy.jetpackcomposecatalog.R.drawable.add
                )
            }
        }
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(id = drawable),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyTitleDialog(title: String, modifier: Modifier) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_XL
)
@Composable
fun MyDialogPreview() {
    JetpackComposeCatalogTheme {
        Column {

        }
    }
}