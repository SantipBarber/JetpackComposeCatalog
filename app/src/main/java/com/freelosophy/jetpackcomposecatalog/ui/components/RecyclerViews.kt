package com.freelosophy.jetpackcomposecatalog.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.freelosophy.jetpackcomposecatalog.R
import com.freelosophy.jetpackcomposecatalog.model.SuperHero

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Aris", "Santi", "Pepe", "Manolo")
    LazyColumn() {
        item { Text("primer item") }
        items(7){
            Text(text="Este es el item $it")
        }
        items(myList){ name ->
            Text("Hola me llamo $name")
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getSuperHeroes()){ superhero ->
            ItemHero(itemHero = superhero) { Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show() }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroGridView() {
    //  GridCells.Fixed(2)
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Adaptive(200.dp),
        content = {
        items(getSuperHeroes()){ superhero ->
            ItemHero(itemHero = superhero) { Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show() }
        }
    },
    contentPadding = PaddingValues(horizontal =  16.dp, vertical = 8.dp)
    )

}

@Composable
fun ItemHero(itemHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(itemHero) }
            .padding(horizontal = 4.dp, vertical = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(itemHero.photo),
                contentDescription = "Superhero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = itemHero.superheroName, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = itemHero.realName, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
            Text(text = itemHero.publisher, modifier = Modifier
                .align(Alignment.End)
                .padding(4.dp), fontSize = 10.sp)

        }
    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero(superheroName = "Spiderman", realName = "Petter Parker", publisher = "Marvel", R.drawable.spiderman),
        SuperHero(superheroName = "Wolverine", realName = "James Howlett", publisher = "Marvel", R.drawable.logan),
        SuperHero(superheroName = "Batman", realName = "Bruce Wayne", publisher = "DC", R.drawable.batman),
        SuperHero(superheroName = "Thor", realName = "Thor Odinson", publisher = "Marvel", R.drawable.thor),
        SuperHero(superheroName = "Flash", realName = "Barry Allen", publisher = "DC", R.drawable.flash),
        SuperHero(superheroName = "Green Lantern", realName = "Jay Garrick", publisher = "DC", R.drawable.green_lantern),
        SuperHero(superheroName = "Wonder Woman", realName = "Princess Diana", publisher = "DC", R.drawable.wonder_woman)
    )
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_4_XL)
@Composable
fun MyRecyclerView() {
    SuperHeroView()
}
