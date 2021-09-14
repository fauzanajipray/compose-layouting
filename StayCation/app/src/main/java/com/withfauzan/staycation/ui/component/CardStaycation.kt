package com.withfauzan.staycation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.withfauzan.staycation.ui.theme.Blue500
import com.withfauzan.staycation.ui.theme.Gray200

@Composable
fun CardStaycation(
    title : String,
    image : Painter,
    subtitle : String,
    modifier : Modifier = Modifier,
    imageModifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Blue500
            )
            Spacer(modifier = Modifier.padding(bottom = 2.dp))
            Text(
                text = subtitle,
                fontSize = 11.sp,
                fontWeight = FontWeight.Light,
                color = Gray200
            )

        }
    }
}