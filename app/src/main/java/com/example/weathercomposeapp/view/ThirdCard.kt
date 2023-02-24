package com.example.weathercomposeapp.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.repository_model.WeatherData


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ThirdCard(data: WeatherData) {
    val list = getItemDailyList(data)
    Card(
        modifier = Modifier
            .padding(8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        backgroundColor = Color.Transparent.copy(alpha = 0.2f)
    ) {
        Column(modifier = Modifier.padding(5.dp).fillMaxWidth()) {
            for(i in list.indices){
                ItemDailyInfo(list[i])
            }
        }
    }
}

@Composable
fun ItemDailyInfo(itemDay: ItemDay) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(2.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = itemDay.day,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .height(20.dp)
                .width(100.dp)
        )
        Image(
            painter = painterResource(id = itemDay.icon),
            contentDescription = "icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(60.dp)
                .width(60.dp)
        )
        Text(
            text = itemDay.minMaxTemperature,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .height(20.dp)
                .width(180.dp)
        )
    }
}

data class ItemDay(
    val day: String,
    val icon: Int,
    val minMaxTemperature: String
)

@RequiresApi(Build.VERSION_CODES.O)
fun getItemDailyList(data: WeatherData) = (1..4).map {
    val minT = data.list5DaysWeather[it].minValue!!
    val maxT = data.list5DaysWeather[it].maxValue!!
    ItemDay(
        day = getWeekday(it),
        icon = R.drawable.sunny_ic,
        minMaxTemperature = setMaxAndMinTemperature(minT, maxT)
    )
}


