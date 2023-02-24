package com.example.weathercomposeapp.view

import android.annotation.SuppressLint
import android.icu.text.MeasureFormat
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.icu.util.Measure
import android.icu.util.MeasureUnit
import android.media.Image
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme


import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.repository_model.WeatherData
import com.example.weathercomposeapp.ui.theme.Purple500


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(data: WeatherData) {
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
        }
    }
}
@Composable
fun WeatherBackground() {
    Image(
        painter = painterResource(id = R.mipmap.blue_sky_bg),
        contentDescription = "background",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

