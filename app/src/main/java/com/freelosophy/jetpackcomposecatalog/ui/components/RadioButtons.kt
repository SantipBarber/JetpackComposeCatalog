package com.freelosophy.jetpackcomposecatalog.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            JetpackComposeCatalogTheme {
//                // A surface container using the 'background' color from the theme
//                var selected by remember{ mutableStateOf("Santi") }
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
////                    MyTriStatusCheckBox()
////                    val myOptions = getOptions(listOf("Santi", "Ejemplo", "Picachu"))
//                    Column {
//                        MyRadioButtonList(selected) { selected = it }
////                        myOptions.forEach {
////                            MyCheckBoxWithTextCompleted(it)
////                        }
//                    }
//
//                }
//            }
//        }
//    }
//}

@Composable
fun MyRadioButtonList(name: String, modifier: Modifier, onItemSelected:(String) -> Unit){
    Column(Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
        ){
            RadioButton(
                selected = name == "Santi", onClick = { onItemSelected("Santi") },
            )
            Text("Santi")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
        ){
            RadioButton(
                selected = name == "Goku", onClick = {  onItemSelected("Goku") },
            )
            Text("Goku")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
        ){
            RadioButton(
                selected = name == "Picachu", onClick = {  onItemSelected("Picachu") },
            )
            Text("Picachu")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier
        ){
            RadioButton(
                selected = name == "Goliat", onClick = {  onItemSelected("Goliat") },
            )
            Text("Goliat")
        }
    }
}

@Composable
fun MyRadioButton() {
    var selected by rememberSaveable { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        RadioButton(
            selected = selected, onClick = { selected = !selected },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledColor = Color.Green
            )
        )
        Text("Púlsame para que cambie ;)")
    }
}
