package com.example.weathercomposeapp.repository_model

import com.example.weathercomposeapp.repository_model.api.Each12H
import com.example.weathercomposeapp.repository_model.api.Each5Days

data class WeatherData(
    var observationDateTime: String?,
    var currWeatherPhrase: String?,
    var isDayTime: Boolean?,
    var currTemperature: Double?,
    var realFeelTemperature: Double?,
    var list5DaysWeather: List<Each5Days>,
    var list12HWeather: List<Each12H>
)
