package com.example.weathercomposeapp.repository_model.api

import com.google.gson.annotations.SerializedName
/**
 * Data class containing the JSON response from the REST API of the 12 hours forecast.
 */
data class Forecast12HData(
    @SerializedName("EpochDateTime") val epochDateTime: Long,
    @SerializedName("WeatherIcon") val weatherIcon: Int,
    @SerializedName("Temperature") val hourlyTemperature: HourlyTemperature
)
data class HourlyTemperature(
    @SerializedName("Value") val hourlyTempValue : Double
)