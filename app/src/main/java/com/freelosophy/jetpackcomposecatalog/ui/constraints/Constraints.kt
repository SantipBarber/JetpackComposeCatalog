package com.freelosophy.jetpackcomposecatalog.ui.constraints

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showSystemUi = true)
@Composable
fun ConstraintsBasic() {
    ConstraintLayout(
        modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .border(3.dp, Color.DarkGray)
            .background(Color.LightGray)
    ) {
        val (boxRed, boxBlue, boxYellow, boxMagenta, boxGreen) = createRefs()
        Box(modifier = Modifier
            .size(128.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(128.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)
            })
        Box(modifier = Modifier
            .size(128.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(128.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)

            })
        Box(modifier = Modifier
            .size(128.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)
            })
    }
}