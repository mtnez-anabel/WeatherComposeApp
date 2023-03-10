package com.example.weathercomposeapp.repository_model.db

import com.example.weathercomposeapp.repository_model.api.Each12H
import com.example.weathercomposeapp.repository_model.api.Each5Days
import com.example.weathercomposeapp.repository_model.WeatherData
import com.example.weathercomposeapp.view.iconsDay

class FixedData {
    companion object {
        val fixedData = WeatherData(
            observationDateTime = "2022-03-14T12:12:00+01:00",
            currWeatherPhrase = "Mostly clear",
            isDayTime = false,
            currTemperature = 18.5,
            realFeelTemperature = 17.4,
            list5DaysWeather = listOf(
                Each5Days(
                    minValue = 7.3,
                    maxValue = 21.9,
                    iconDay = 1,
                    dayPhrase = "Sunny",
                    iconNight = 33,
                    nightPhrase = "Clear"
                ), Each5Days(
                    minValue = 7.7,
                    maxValue = 20.3,
                    iconDay = 1,
                    dayPhrase = "Sunny",
                    iconNight = 33,
                    nightPhrase = "Clear"
                ), Each5Days(
                    minValue = 8.1,
                    maxValue = 20.2,
                    iconDay = 2,
                    dayPhrase = "Mostly sunny",
                    iconNight = 33,
                    nightPhrase = "Clear"
                ), Each5Days(
                    minValue = 8.8,
                    maxValue = 19.5,
                    iconDay = 4,
                    dayPhrase = "Intermittent clouds",
                    iconNight = 34,
                    nightPhrase = "Mostly clear"
                ), Each5Days(
                    minValue = 9.0,
                    maxValue = 20.2,
                    iconDay = 3,
                    dayPhrase = "Rain",
                    iconNight = 34,
                    nightPhrase = "Mostly clear"
                )
            ),
            list12HWeather = listOf(
                Each12H(
                    epochDateTime = 1648144800,
                    isDaylight = false,
                    iconPhrase = "Cloudy",
                    hourlyTempValue = 16.2
                ),
                Each12H(
                    epochDateTime = 1648148400,
                    isDaylight = false,
                    iconPhrase = "Cloudy",
                    hourlyTempValue = 14.0
                ),
                Each12H(
                    epochDateTime = 1648152000,
                    isDaylight = false,
                    iconPhrase = "Mostly cloudy",
                    hourlyTempValue = 12.5
                ),
                Each12H(
                    epochDateTime = 1648155600,
                    isDaylight = false,
                    iconPhrase = "Intermittent clouds",
                    hourlyTempValue = 10.9
                ),
                Each12H(
                    epochDateTime = 1648159200,
                    isDaylight = false,
                    iconPhrase = "Partly cloudy",
                    hourlyTempValue = 10.2
                ),
                Each12H(
                    epochDateTime = 1648162800,
                    isDaylight = false,
                    iconPhrase = "Mostly clear",
                    hourlyTempValue = 9.4
                ),
                Each12H(
                    epochDateTime = 1648166400,
                    isDaylight = false,
                    iconPhrase = "Mostly clear",
                    hourlyTempValue = 8.9
                ),
                Each12H(
                    epochDateTime = 1648170000,
                    isDaylight = false,
                    iconPhrase = "Mostly clear",
                    hourlyTempValue = 8.6
                ),
                Each12H(
                    epochDateTime = 1648173600,
                    isDaylight = false,
                    iconPhrase = "Clear",
                    hourlyTempValue = 8.3
                ),
                Each12H(
                    epochDateTime = 1648177200,
                    isDaylight = false,
                    iconPhrase = "Partly cloudy",
                    hourlyTempValue = 7.9
                ),
                Each12H(
                    epochDateTime = 1648180800,
                    isDaylight = false,
                    iconPhrase = "Intermittent clouds",
                    hourlyTempValue = 7.6
                ),
                Each12H(
                    epochDateTime = 1648184400,
                    isDaylight = false,
                    iconPhrase = "Intermittent clouds",
                    hourlyTempValue = 7.3
                )
            )
        )
    }
}