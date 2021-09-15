package com.withfauzan.staycation.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.withfauzan.staycation.data.City
import com.withfauzan.staycation.data.Places
import com.withfauzan.staycation.data.ProvideData
import com.withfauzan.staycation.data.Type
import com.withfauzan.staycation.ui.component.CardStaycation
import com.withfauzan.staycation.ui.component.Chip
import com.withfauzan.staycation.ui.component.TopBar
import com.withfauzan.staycation.ui.theme.*


@Composable
fun DiscoverScreen() {
    val scrollState = rememberLazyListState()

    val listType = ProvideData.listType
    val listStay = ProvideData.listStay
    val listCity = ProvideData.listCity

    Scaffold(
        bottomBar = {
            BottomBar(
                listNav = ProvideData.listNav,
                modifier = Modifier
                    .shadow(elevation = 6.dp)
                    .padding()
                    .background(MaterialTheme
                        .colors
                        .background
                        .copy(0.9f)
                    )
                    .fillMaxWidth()
                    .height(60.dp)
            )
        }
    ) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier.fillMaxSize().padding(bottom = 70.dp)
        ) {
            item {
                TopBar(
                    "Discover",
                    "Find great moments",
                    Modifier.padding(
                        horizontal = 24.dp,
                        vertical = 20.dp
                    )
                )
            }
            item {
                ChipSection(chips = listType)
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                NewsSection(listStay)
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                CitySection(listCity)
                Spacer(modifier = Modifier.height(20.dp))
            }
            item {
                CitySection(listCity)
                Spacer(modifier = Modifier.height(20.dp))
            }
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
            val colorTint = if (isSystemInDarkTheme()) {
                if (selectedChipIndex == it) Blue400 else Blue200
            } else {
                if (selectedChipIndex == it) Blue500 else Gray100
            }
            val paddingStart = if (it == 0) 24.dp else 16.dp
            val paddingEnd = if (it == chips.size - 1) 24.dp else 0.dp

            Chip(
                text = chips[it].text,
                iconId = chips[it].icon,
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
fun NewsSection(
    listPlace: List<Places>
) {
    Column {
        TitleFeature(text = "Newest places")
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow {
            items(listPlace.size) {
                val paddingStart = if (it == 0) 24.dp else 16.dp
                val paddingEnd = if (it == listPlace.size - 1) 24.dp else 0.dp
                val backgroundColor = if (isSystemInDarkTheme()) Blue300 else Color.White
                val borderSize = if (isSystemInDarkTheme()) 0.dp else 1.dp

                CardStaycation(
                    title =listPlace[it].name,
                    subtitle ="$ ${listPlace[it].price}/night • ${listPlace[it].capacity} Guests",
                    imageId = listPlace[it].image,
                    modifier = Modifier
                        .padding(start = paddingStart, end = paddingEnd)
                        .height(240.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .border(
                            width = borderSize,
                            shape = RoundedCornerShape(6.dp),
                            color = if (isSystemInDarkTheme()) backgroundColor else Gray100
                        )
                        .background(backgroundColor),
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
        TitleFeature(text = "Cities you love")
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow {
            items(listCity.size) {
                val paddingStart = if (it == 0) 24.dp else 16.dp
                val paddingEnd = if (it == listCity.size - 1) 24.dp else 0.dp
                val backgroundColor = if (isSystemInDarkTheme()) Blue300 else Color.White
                val borderSize = if (isSystemInDarkTheme()) 0.dp else 1.dp

                CardStaycation(
                    title =listCity[it].name,
                    subtitle ="${listCity[it].total} place to stay",
                    imageId = listCity[it].image,
                    modifier = Modifier
                        .padding(start = paddingStart, end = paddingEnd)
                        .height(170.dp)
                        .width(140.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .border(
                            width = borderSize,
                            shape = RoundedCornerShape(6.dp),
                            color = if (isSystemInDarkTheme()) backgroundColor else Gray100
                        )
                        .background(backgroundColor),
                    imageModifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
            }
        }
    }
}


@Composable
fun BottomBar(
    listNav: List<Type>,
    modifier: Modifier = Modifier
) {
    var selectedNavIndex by remember {
        mutableStateOf(0)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        listNav.forEachIndexed { index, nav ->
            var tint = if (isSystemInDarkTheme()) {
                if (selectedNavIndex == index) Blue400 else Blue200
            } else {
                if (selectedNavIndex == index) Blue500 else Gray100
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clickable {
                        selectedNavIndex = index
                    }
                    .padding(16.dp)
                    .clip(RoundedCornerShape(100.dp))
            ){
                Icon(
                    painter = painterResource(id = nav.icon),
                    contentDescription = nav.text,
                    tint = tint
                )
            }
        }
    }
}


