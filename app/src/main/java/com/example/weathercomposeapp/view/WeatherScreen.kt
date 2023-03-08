package com.example.weathercomposeapp.view


import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.repository_model.WeatherData


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(data: WeatherData, context: Context) {
    val pair = getBackgroundLogo(data)
    val background = pair.first
    val logo = pair.second
    Box(modifier = Modifier.fillMaxSize()) {
        WeatherBackground(background)
        LazyColumn(
        ) {
            item {
                FirstCard(data)
            }
            item {
                SecondCard(data)
            }
            item {
                ThirdCard(data)
            }
            item {
                AccuWeatherInfo(context, logo)
            }
        }
    }
}

@Composable
fun WeatherBackground(bg: Int) {
    Image(
        painter = painterResource(id = bg),
        contentDescription = "background",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

