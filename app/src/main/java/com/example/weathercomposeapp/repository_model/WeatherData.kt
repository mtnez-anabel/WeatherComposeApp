package com.example.weathercomposeapp.repository_model

data class WeatherData(
    var observationDateTime: String?,
    var currWeatherPhrase: String?,
    var isDayTime: Boolean?,
    var currTemperature: Double?,
    var realFeelTemperature: Double?,
    var list5DaysWeather: List<Each5Days>,
    var list12HWeather: List<Each12H>
)
