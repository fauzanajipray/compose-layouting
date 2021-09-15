package com.withfauzan.staycation.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class City (
    val name : String,
    val total : Int,
    @DrawableRes val image: Int
)