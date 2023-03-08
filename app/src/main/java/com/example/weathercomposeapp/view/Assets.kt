package com.example.weathercomposeapp.view

import com.example.weathercomposeapp.R
import com.example.weathercomposeapp.repository_model.WeatherData

val iconsDay = mapOf(
    "Sunny" to R.drawable.sunny_day_ic,
    "Mostly sunny" to R.drawable.mostly_sunny_day_ic,
    "Partly sunny" to R.drawable.partly_sunny_day_ic,
    "Intermittent clouds" to R.drawable.intermittent_clouds_day_ic,
    "Hazy sunshine" to R.drawable.hazy_sunshine_day_ic,
    "Mostly cloudy" to R.drawable.mostly_cloudy_day_ic,
    "Mostly cloudy w/ showers" to R.drawable.mostly_cloudy_showers_day_ic,
    "Partly sunny w/ showers" to R.drawable.partly_sunny_showers_day_ic,
    "Mostly cloudy w/ t-storms" to R.drawable.mostly_cloudy_t_storms_day_ic,
    "Partly sunny w/ t-storms" to R.drawable.partly_sunny_t_storms_day_ic,
    "Mostly cloudy w/ flurries" to R.drawable.mostly_cloudy_flurries_day_ic,
    "Partly sunny w/ flurries" to R.drawable.partly_sunny_flurries_day_ic,
    "Mostly cloudy w/ snow" to R.drawable.mostly_cloudy_snow_day_ic,
    "Cloudy" to R.drawable.cloudy_day_night_ic,
    "Dreary" to R.drawable.dreary_overcast_day_night_ic,
    "Fog" to R.drawable.fog_day_night_ic,
    "Showers" to R.drawable.showers_day_night_ic,
    "T-storms" to R.drawable.t_storms_day_night_ic,
    "Rain" to R.drawable.rain_day_night_ic,
    "Flurries" to R.drawable.flurries_day_night_ic,
    "Snow" to R.drawable.snow_day_night_ic,
    "Ice" to R.drawable.ice_day_night_ic,
    "Sleet" to R.drawable.sleet_day_night_ic,
    "Freezing rain" to R.drawable.freezing_rain_day_night_ic,
    "Rain and snow" to R.drawable.rain_snow_day_night_ic,
    "Hot" to R.drawable.hot_day_night_ic,
    "Cold" to R.drawable.cold_day_night_ic,
    "Windy" to R.drawable.windy_day_night_ic,
)

val iconsNight = mapOf(
    "Cloudy" to R.drawable.cloudy_day_night_ic,
    "Dreary" to R.drawable.dreary_overcast_day_night_ic,
    "Fog" to R.drawable.fog_day_night_ic,
    "Showers" to R.drawable.showers_day_night_ic,
    "T-storms" to R.drawable.t_storms_day_night_ic,
    "Rain" to R.drawable.rain_day_night_ic,
    "Flurries" to R.drawable.flurries_day_night_ic,
    "Snow" to R.drawable.snow_day_night_ic,
    "Ice" to R.drawable.ice_day_night_ic,
    "Sleet" to R.drawable.sleet_day_night_ic,
    "Freezing rain" to R.drawable.freezing_rain_day_night_ic,
    "Rain and snow" to R.drawable.rain_snow_day_night_ic,
    "Hot" to R.drawable.hot_day_night_ic,
    "Cold" to R.drawable.cold_day_night_ic,
    "Windy" to R.drawable.windy_day_night_ic,
    "Clear" to R.drawable.clear_night_ic,
    "Mostly clear" to R.drawable.mostly_clear_night_ic,
    "Partly cloudy" to R.drawable.partly_cloudy_night_ic,
    "Intermittent clouds" to R.drawable.intermittent_clouds_night_ic,
    "Hazy moonlight" to R.drawable.hazy_moonlight_night_ic,
    "Mostly cloudy" to R.drawable.mostly_cloudy_night_ic,
    "Partly cloudy w/ showers" to R.drawable.partly_cloudy_showers_night_ic,
    "Mostly cloudy w/ showers" to R.drawable.mostly_cloudy_showers_night_ic,
    "Partly cloudy w/ t-storms" to R.drawable.partly_cloudy_t_storms_night_ic,
    "Mostly cloudy w/ t-storms" to R.drawable.mostly_cloudy_t_storms_night_ic,
    "Mostly cloudy w/ flurries" to R.drawable.mostly_cloudy_flurries_night_ic,
    "Mostly cloudy w/ snow" to R.drawable.mostly_cloudy_snow_night_ic
)

fun getIconCurrCond(data: WeatherData): Int {
    return if (data.isDayTime!!)
        iconsDay[data.currWeatherPhrase]!!
    else
        iconsNight[data.currWeatherPhrase]!!
}

fun getIconEach12H(i: Int, data: WeatherData): Int {
    return if (data.list12HWeather[i].isDaylight!!)
        iconsDay[data.list12HWeather[i].iconPhrase]!!
    else
        iconsNight[data.list12HWeather[i].iconPhrase]!!
}

fun getIconEach5D(i: Int, data: WeatherData): Int {
    return iconsDay[data.list5DaysWeather[i].dayPhrase]!!
}

fun getBackgroundLogo(data: WeatherData): Pair<Int, Int> {
    return if (data.isDayTime!!) {
        when (data.currWeatherPhrase!!) {
            "Sunny", "Mostly sunny" -> Pair(R.mipmap.sunny_sky_day_bg, R.drawable.accuweather_dark)
            "Mostly cloudy w/ showers", "Partly sunny w/ showers", "Mostly cloudy w/ t-storms",
            "Partly sunny w/ t-storms", "Showers", "T-storms",
            "Rain", "Freezing rain" -> Pair(R.mipmap.rain_day_bg, R.drawable.accuweather_dark)
            "Mostly cloudy w/ snow",  "Snow", "Ice" , "Sleet" ,
            "Rain and snow" -> Pair(R.mipmap.snow_day_bg, R.drawable.accuweather_dark)
            else -> Pair(R.mipmap.partly_sunny_clouds_day_bg, R.drawable.accuweather_dark)
        }
    } else {
        when (data.currWeatherPhrase!!){
            "Cloudy", "Dreary", "Fog", "Flurries", "Cold", "Hazy moonlight",
            "Mostly cloudy", "Mostly cloudy w/ flurries" -> Pair(R.mipmap.cloudy_night_bg, R.drawable.accuweather)
            "Showers", "T-storms", "Rain", "Freezing rain", "Partly cloudy w/ showers",
            "Mostly cloudy w/ showers", "Partly cloudy w/ t-storms",
            "Mostly cloudy w/ t-storms" -> Pair(R.mipmap.rain_night_bg, R.drawable.accuweather_dark)
            "Snow", "Ice", "Sleet", "Rain and snow",
            "Mostly cloudy w/ snow" -> Pair(R.mipmap.snow_night_bg, R.drawable.accuweather_dark)
            else -> Pair(R.mipmap.partly_clouds_night_bg, R.drawable.accuweather_dark)

        }
    }
}