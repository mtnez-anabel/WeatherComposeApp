package com.example.weathercomposeapp.view


import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weathercomposeapp.repository_model.WeatherData


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreenPortrait(data: WeatherData, context: Context) {
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreenLandscape(data: WeatherData, context: Context) {
    val pair = getBackgroundLogo(data)
    val background = pair.first
    val logo = pair.second
    Box(modifier = Modifier.fillMaxSize()) {
        WeatherBackground(background)
        LazyColumn(
        ) {
            item {
                Row(
                    modifier = Modifier.background(Color.Transparent),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .weight(1f)
                    ) {
                        FirstCard(data)
                    }
                    Box(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .weight(1f)
                    ) {
                        ThirdCard(data)
                    }
                }
            }
            item {
                SecondCard(data)
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

