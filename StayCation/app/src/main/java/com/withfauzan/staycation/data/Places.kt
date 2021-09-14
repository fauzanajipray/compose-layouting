package com.withfauzan.staycation.data

import androidx.compose.ui.graphics.painter.Painter

data class Places(
    val name: String,
    val location: String,
    val price: Int,
    val capacity: Int,
    val image: Painter
)
