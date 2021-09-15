package com.withfauzan.staycation.data

import androidx.compose.ui.res.painterResource
import com.withfauzan.staycation.R

object ProvideData {
    val listType = listOf(
        Type(R.drawable.ic_apartment,"Apartement"),
        Type(R.drawable.ic_house,"House"),
        Type(R.drawable.ic_studio,"Studio")
    )
    val listStay = listOf(
        Places("Jojo's Resort", "Bali, Indonesia",80,6, R.drawable.image_category_1),
        Places("Futurest", "Bandung, Indonesia",22,2, R.drawable.image_category_2),
        Places("Jojo's Resort", "Jogja, Indonesia",80,6, R.drawable.image_category_3),
        Places("Jojo's Resort", "Bali, Indonesia",80,6, R.drawable.image_category_1),
        Places("Futurest", "Bandung, Indonesia",22,2, R.drawable.image_category_2),
        Places("Jojo's Resort", "Jogja, Indonesia",80,6, R.drawable.image_category_3)
    )
    val listCity = listOf(
        City("Bali",19542, R.drawable.city_1),
        City("Jogja",9542, R.drawable.city_2),
        City("Malang",5032, R.drawable.city_3)
    )
    val listNav = listOf(
        Type(R.drawable.ic_home,"Home"),
        Type(R.drawable.ic_save,"Save"),
        Type(R.drawable.ic_search,"Search"),
        Type(R.drawable.ic_user,"Profile")
    )

}