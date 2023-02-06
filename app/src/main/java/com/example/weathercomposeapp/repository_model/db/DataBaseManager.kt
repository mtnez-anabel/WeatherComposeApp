package com.example.weathercomposeapp.repository_model.db

import com.example.weathercomposeapp.repository_model.Each12H
import com.example.weathercomposeapp.repository_model.Each5Days
import com.example.weathercomposeapp.repository_model.WeatherData
import javax.inject.Inject

class DataBaseManager @Inject constructor(
    private val dao: WeatherDao) {

    suspend fun setToDB(data: WeatherData) {
        val currCond = CurrentConditionsEntity(
            observationDateTime = data.observationDateTime!!,
            currWeatherPhrase = data.currWeatherPhrase!!,
            isDayTime = data.isDayTime!!,
            currTemperature = data.currTemperature!!,
            realFeelTemperature = data.realFeelTemperature!!
        )
        val list5D = getListEach5DaysEntity(data)
        val list12H = getListEach12HoursEntity(data)
        dao.insertData(currCond, list5D, list12H)
    }

    suspend fun getFromDB(): WeatherData?{
        val weatherRelations = dao.getWeatherData()
        val list5DaysWeather = mutableListOf<Each5Days>()
        for (i in 0..4) {
            val each5Days = Each5Days(
                minValue = weatherRelations.list5D[i].minValue,
                maxValue = weatherRelations.list5D[i].maxValue,
                iconDay = weatherRelations.list5D[i].iconDay,
                dayPhrase = weatherRelations.list5D[i].dayPhrase,
                iconNight = weatherRelations.list5D[i].iconNight,
                nightPhrase = weatherRelations.list5D[i].nightPhrase
            )
            list5DaysWeather.add(each5Days)
        }
        val list12HWeather = mutableListOf<Each12H>()
        for (i in 0..11) {
            val each12Hours = Each12H(
                epochDateTime = weatherRelations.list12H[i].epochDateTime,
                weatherIcon = weatherRelations.list12H[i].weatherIcon,
                hourlyTempValue = weatherRelations.list12H[i].hourlyTempValue
            )
            list12HWeather.add(each12Hours)
        }
        return WeatherData(
            observationDateTime = weatherRelations.currCond.observationDateTime,
            currWeatherPhrase = weatherRelations.currCond.currWeatherPhrase,
            isDayTime = weatherRelations.currCond.isDayTime,
            currTemperature = weatherRelations.currCond.currTemperature,
            realFeelTemperature = weatherRelations.currCond.realFeelTemperature,
            list5DaysWeather = list5DaysWeather,
            list12HWeather = list12HWeather
        )
    }

    suspend fun updateDataBase( data: WeatherData) {
        val dataEntities = dao.getWeatherData()
        val currCond = getCurrentConditionsEntity(data)
        val list5D = getListEach5DaysEntity(data)
        val list12H = getListEach12HoursEntity(data)
        dao.updateData(
            dataEntities.currCond,
            dataEntities.list5D,
            dataEntities.list12H,
            currCond,
            list5D,
            list12H
        )
    }

    private fun getCurrentConditionsEntity(data: WeatherData): CurrentConditionsEntity {
        return CurrentConditionsEntity(
            observationDateTime = data.observationDateTime!!,
            currWeatherPhrase = data.currWeatherPhrase!!,
            isDayTime = data.isDayTime!!,
            currTemperature = data.currTemperature!!,
            realFeelTemperature = data.realFeelTemperature!!
        )
    }

    private fun getListEach5DaysEntity(data: WeatherData): List<Each5DaysEntity> {
        val list5D = mutableListOf<Each5DaysEntity>()
        for (i in 0..4) {
            val each5Days = Each5DaysEntity(
                idDay = i,
                momentObservation5D = data.observationDateTime!!,
                minValue = data.list5DaysWeather[i].minValue!!,
                maxValue = data.list5DaysWeather[i].maxValue!!,
                iconDay = data.list5DaysWeather[i].iconDay!!,
                dayPhrase = data.list5DaysWeather[i].dayPhrase!!,
                iconNight = data.list5DaysWeather[i].iconNight!!,
                nightPhrase = data.list5DaysWeather[i].nightPhrase!!
            )
            list5D.add(each5Days)
        }
        return list5D
    }

    private fun getListEach12HoursEntity(data: WeatherData): List<Each12HoursEntity> {
        val list12H = mutableListOf<Each12HoursEntity>()
        for (i in 0..11) {
            val each12Hours = Each12HoursEntity(
                idHour = i,
                momentObservation12H = data.observationDateTime!!,
                epochDateTime = data.list12HWeather[i].epochDateTime!!,
                weatherIcon = data.list12HWeather[i].weatherIcon!!,
                hourlyTempValue = data.list12HWeather[i].hourlyTempValue!!
            )
            list12H.add(each12Hours)
        }
        return list12H
    }
}