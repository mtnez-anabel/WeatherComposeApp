package com.example.weathercomposeapp.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun SecondCard(data: WeatherData) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        backgroundColor = Color.Transparent.copy(alpha = 0.2f),

        ) {
        LazyRow(modifier = Modifier.padding(5.dp)) {
            items(getItemHourList(data)) {
                ItemHourlyInfo( it)
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ItemHourlyInfo(itemHour: ItemHour) {
    Column(
        modifier = Modifier
            .padding(2.dp)
    ) {
        Text(
            text = itemHour.hour,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .height(20.dp)
                .width(60.dp)
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(id = itemHour.icon),
            contentDescription = "icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(60.dp)
                .width(60.dp)
        )
        Text(
            text = itemHour.temperature,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .height(20.dp)
                .width(60.dp)
                .fillMaxWidth()
        )
    }
}
data class ItemHour(
    val hour: String,
    val icon: Int,
    val temperature: String
)
@RequiresApi(Build.VERSION_CODES.O)
fun getItemHourList(data: WeatherData) = (0..11).map {
    val epoc = data.list12HWeather[it].epochDateTime!!
    val eachTemp = data.list12HWeather[it].hourlyTempValue!!
    ItemHour(
        hour = getEachHour(epoc),
        icon = R.drawable.sunny_ic,
        temperature = getEachTempHour(eachTemp)
    )
}