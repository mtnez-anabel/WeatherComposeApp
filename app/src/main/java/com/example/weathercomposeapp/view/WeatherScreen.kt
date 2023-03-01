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
    Box(modifier = Modifier.fillMaxSize()) {
        WeatherBackground()
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
                AccuWeatherInfo(context)
            }
        }
    }
}

@Composable
fun WeatherBackground() {
    Image(
        painter = painterResource(id = R.mipmap.blue_sky_bg),
        contentDescription = "background",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

