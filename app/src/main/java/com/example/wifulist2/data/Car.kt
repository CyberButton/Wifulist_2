package com.example.wifulist2.data

import androidx.annotation.DrawableRes

data class Car(
    val name: String,
    @DrawableRes val image: Int,
    val specs: String
)
