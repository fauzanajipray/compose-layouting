package com.withfauzan.staycation.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class Places(
    val name: String,
    val location: String,
    val price: Int,
    val capacity: Int,
    @DrawableRes val image: Int
)
