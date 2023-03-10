package com.example.weathercomposeapp.repository_model.api

import com.example.weathercomposeapp.repository_model.WeatherData
import javax.inject.Inject

class DataManagerAPIClient @Inject constructor(
    private val apiCurrentCondition: CurrCondAPIService,
    private val apiForecast5D: Forecast5DAPIService,
    private val apiForecast12H: Forecast12HAPIService
) {

    suspend fun getAllWeatherData(): WeatherData? {
        val responseCurrentCond = apiCurrentCondition.getCurrentCondition()
        val responseForecast5D = apiForecast5D.getForecast5D()
        val responseForecast12H = apiForecast12H.getForecast12H()
        //isSuccessful() returns true if code() is in the range [200..300):
        if (!responseCurrentCond.isSuccessful || !responseForecast5D.isSuccessful || !responseForecast12H.isSuccessful)
            return null
        val listD = mutableListOf<Each5Days>()
        for (i in 0..4) {
            val minV = responseForecast5D.body()?.list?.get(i)?.temperature?.minimum?.minValue
            val maxV = responseForecast5D.body()?.list?.get(i)?.temperature?.maximum?.maxValue
            val icDay = responseForecast5D.body()?.list?.get(i)?.day?.iconDay
            val dPhrase = responseForecast5D.body()?.list?.get(i)?.day?.dayPhrase
            val iNight = responseForecast5D.body()?.list?.get(i)?.night?.iconNight
            val nPhrase = responseForecast5D.body()?.list?.get(i)?.night?.nightPhrase
            listD.add(i, (Each5Days(minV, maxV, icDay, dPhrase, iNight, nPhrase)))
        }
        val listH = mutableListOf<Each12H>()
        for (i in 0..11) {
            val epDateTime = responseForecast12H.body()?.get(i)?.epochDateTime
            val isDaylight = responseForecast12H.body()?.get(i)?.isDaylight
            val iconPhrase =  responseForecast12H.body()?.get(i)?.iconPhrase
            val hTempValue = responseForecast12H.body()?.get(i)?.hourlyTemperature?.hourlyTempValue
            listH.add(i, Each12H(epDateTime, isDaylight,iconPhrase, hTempValue))
        }

        return WeatherData(
            observationDateTime = responseCurrentCond.body()?.get(0)?.localObservationDateTime,
            currWeatherPhrase = responseCurrentCond.body()?.get(0)?.weatherPhrase,
            isDayTime = responseCurrentCond.body()?.get(0)?.isDayTime,
            currTemperature = responseCurrentCond.body()
                ?.get(0)?.temperature?.tempMetric?.tempValueDouble,
            realFeelTemperature = responseCurrentCond.body()
                ?.get(0)?.realFeelTemperature?.tempRealFeelMetric?.tempRealFeelValueDouble,
            list5DaysWeather = listD,
            list12HWeather = listH
        )
    }

}