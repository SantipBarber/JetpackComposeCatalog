package com.freelosophy.jetpackcomposecatalog.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var superheroName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
