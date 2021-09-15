package com.withfauzan.staycation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.withfauzan.staycation.ui.theme.Gray200

@Composable
fun CardStaycation(
    title : String,
    imageId : Int,
    subtitle : String,
    modifier : Modifier = Modifier,
    imageModifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )
        Column(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1
            )
            Text(
                text = subtitle,
                fontSize = 11.sp,
                fontWeight = FontWeight.Light,
                color = Gray200,
                maxLines = 1
            )
        }
    }
}