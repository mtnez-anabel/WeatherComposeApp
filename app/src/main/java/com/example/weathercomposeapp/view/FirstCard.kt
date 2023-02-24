package com.example.weathercomposeapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.repository_model.WeatherData
import com.example.weathercomposeapp.ui.theme.Purple500


@Composable
fun FirstCard(data: WeatherData) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Transparent),
        shape = RoundedCornerShape(15.dp),
        elevation = 0.dp,
        backgroundColor = Color.Transparent.copy(alpha = 0.2f)
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .background(Color.Transparent)
        ) {
            TextLocation()
            TextWeatherPhrase(data)
            CurrTempAndIconRow(data)
            TextRealFeel(data)
            TodayInfoRow(data)
        }
    }
}

@Composable
fun TextLocation() {
    Text(
        text = getCity(),
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        color = Purple500,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextWeatherPhrase(data: WeatherData) {
    Text(
        text = data.currWeatherPhrase!!,
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun CurrTempAndIconRow(data: WeatherData) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = setCurrentTemperature(data.currTemperature!!),
            fontSize = 50.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            style = MaterialTheme.typography.h3.copy(
                shadow = Shadow(
                    offset = Offset(14f, 14f),
                    blurRadius = 8f,
                    color = Color.Black.copy(alpha = 0.5f)
                )
            ),
            modifier = Modifier.weight(2f)
        )
        Image(
            painter = painterResource(id = R.drawable.sunny_ic),
            contentDescription = "icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun TextRealFeel(data: WeatherData) {
    Text(
        text = setCurrentRealFeel(data.realFeelTemperature!!),
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.White,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TodayInfoRow(data: WeatherData) {
    Row(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.Today_Text),
            textAlign = TextAlign.End,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Text(
            text = getWeekdayToday(),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Text(
            text = setMaxAndMinTemperature(
                data.list5DaysWeather[0].minValue!!,
                data.list5DaysWeather[0].maxValue!!
            ),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
        )
    }
}
