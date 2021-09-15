package com.withfauzan.staycation.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class Type(
    @DrawableRes val icon: Int,
    val text : String
)