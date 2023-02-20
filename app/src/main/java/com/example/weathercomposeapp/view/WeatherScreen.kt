package com.example.weathercomposeapp.view

import android.annotation.SuppressLint
import android.icu.text.MeasureFormat
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.icu.util.Measure
import android.icu.util.MeasureUnit
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme


import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.repository_model.WeatherData
import com.example.weathercomposeapp.ui.theme.Purple500
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.*

@Composable
fun WeatherScreen(data: WeatherData) {
    Box(modifier = Modifier.fillMaxSize()) {
        WeatherBackground()
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                TextLocation()
                TextWeatherPhrase(data)
                CurrTempAndIconRow(data)
            }
        }
    }
}

@Composable
fun WeatherBackground(){
    Image(
        painter = painterResource(id = R.mipmap.blue_sky_bg),
        contentDescription = "background",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun TextLocation(){
    Text(
        text = getCity(),
        fontSize = 24.sp,
        color = Purple500,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextWeatherPhrase(data: WeatherData){
    Text(
        text = data.currWeatherPhrase!!,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}
@Composable
fun CurrTempAndIconRow(data: WeatherData){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically
    ) {
        Text(
            text = setCurrentTemperature(data.currTemperature!!),
            fontSize = 50.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontWeight =  FontWeight.SemiBold,
            color = Color.White,
            style = MaterialTheme.typography.h3.copy(
                shadow = Shadow(offset = Offset(10f, 10f), blurRadius = 5f, color = Color.Black.copy(alpha = 0.5f))
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

