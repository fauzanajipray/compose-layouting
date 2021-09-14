package com.withfauzan.staycation.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.withfauzan.staycation.R
import com.withfauzan.staycation.data.City
import com.withfauzan.staycation.data.Places
import com.withfauzan.staycation.data.Type
import com.withfauzan.staycation.ui.component.CardStaycation
import com.withfauzan.staycation.ui.component.TopBar
import com.withfauzan.staycation.ui.theme.Blue500
import com.withfauzan.staycation.ui.theme.Gray100
import com.withfauzan.staycation.ui.theme.Gray200
import com.withfauzan.staycation.ui.theme.StayCationTheme


@Composable
fun DiscoverScreen() {
    val scrollState = rememberLazyListState()

    val listType = listOf<Type>(
        Type(painterResource(id = R.drawable.ic_apartment),"Apartement"),
        Type(painterResource(id = R.drawable.ic_house),"Apartement"),
        Type(painterResource(id = R.drawable.ic_studio),"Apartement")
    )
    val listStay = listOf<Places>(
        Places("Jojo's Resort", "",80,6, painterResource(id = R.drawable.image_category_1)),
        Places("Futurest", "",22,2, painterResource(id = R.drawable.image_category_2)),
        Places("Jojo's Resort", "",80,6, painterResource(id = R.drawable.image_category_3))
    )
    val listCity = listOf<City>(
        City("Bali",19542, painterResource(id = R.drawable.city_1)),
        City("Jogja",9542, painterResource(id = R.drawable.city_2)),
        City("Malang",5032,painterResource(id = R.drawable.city_3))
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            TopBar(
                "Discover",
                "Find great moments",
                Modifier.padding(
                    horizontal = 24.dp,
                    vertical = 20.dp
            )
        ) }
        item {
            ChipSection(chips = listType)
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            PlacesSection(listStay)
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            CitySection(listCity)
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview("Discover Screen")
@Preview("Discover Screen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    StayCationTheme {
        Surface(color = MaterialTheme.colors.background) {
            DiscoverScreen()
        }
    }
}

@Composable
fun ChipSection(
    chips: List<Type>,
    modifier: Modifier = Modifier
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(modifier) {
        items(chips.size) {
            val colorTint = if (selectedChipIndex == it) Blue500 else Gray100
            val paddingStart = if (it == 0) 24.dp else 16.dp
            val paddingEnd = if (it == chips.size - 1) 24.dp else 0.dp
            /*
            Chip(
                text = chips[it].text,
                icon = chips[it].icon,
                colorTint = colorTint,
                modifier = Modifier
                    .padding(start = paddingStart, end = paddingEnd)
                    .clip(RoundedCornerShape(6.dp))
                    .clickable {
                        selectedChipIndex = it
                    }
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(6.dp),
                        color = colorTint
                    )
                    .height(40.dp)
                    .padding(horizontal = 10.dp, vertical = 8.dp)
            )
            */

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = paddingStart, end = paddingEnd)
                    .clip(RoundedCornerShape(6.dp))
                    .clickable {
                        selectedChipIndex = it
                    }
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(6.dp),
                        color = colorTint
                    )
                    .height(40.dp)
                    .padding(horizontal = 10.dp, vertical = 8.dp)
            ) {
                Icon(
                    painter = chips[it].icon,
                    contentDescription = "type ${chips[it].text}",
                    tint = colorTint,
                    modifier = Modifier
                        .size(34.dp)
                        .padding(end = 11.dp)
                )
                Text(
                    text = chips[it].text,
                    color = colorTint,
                    fontSize = 12.sp
                )
            }
        }
    }
}



@Composable
fun TitleFeature(
    text : String,
    modifier: Modifier = Modifier
) {
    Text(
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
        color = Gray200,
        text = text,
        modifier = modifier.padding(start = 24.dp)
    )
}

@Composable
fun PlacesSection(
    listPlace: List<Places>
) {
    Column {
        TitleFeature(text = "Newest places")
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow {
            items(listPlace.size) {
                val paddingStart = if (it == 0) 24.dp else 16.dp
                val paddingEnd = if (it == listPlace.size - 1) 24.dp else 0.dp
                CardStaycation(
                    title =listPlace[it].name,
                    subtitle ="$ ${listPlace[it].price}/night • ${listPlace[it].capacity} Guests",
                    image = listPlace[it].image,
                    modifier = Modifier
                        .padding(start = paddingStart, end = paddingEnd)
                        .height(240.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(6.dp),
                            color = Gray100
                        ),
                    imageModifier = Modifier
                        .fillMaxWidth()
                        .height(168.dp)
                )
            }
        }
    }
}

@Composable
fun CitySection(
    listCity: List<City>
) {
    Column {
        TitleFeature(text = "Newest places")
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow {
            items(listCity.size) {
                val paddingStart = if (it == 0) 24.dp else 16.dp
                val paddingEnd = if (it == listCity.size - 1) 24.dp else 0.dp
                CardStaycation(
                    title =listCity[it].name,
                    subtitle ="${listCity[it].total} place to stay",
                    image = listCity[it].image,
                    modifier = Modifier
                        .padding(start = paddingStart, end = paddingEnd)
                        .height(168.dp)
                        .width(140.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(6.dp),
                            color = Gray100
                        ),
                    imageModifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
            }
        }
    }
}

