package com.example.weathercomposeapp.repository_model

import com.example.weathercomposeapp.repository_model.api.DataManagerAPIClient
import com.example.weathercomposeapp.repository_model.db.DataBaseManager
import com.example.weathercomposeapp.repository_model.db.FixedData
import javax.inject.Inject

/**
 * [Repository] manages queries and allows to use multiple backends.
 *
 * It implements the logic for deciding whether to fetch
 * data from the network or use results cached in the local database.
 */
interface Repository {
    suspend fun getWeatherDataFromApi(): WeatherData?
    suspend fun getWeatherDataFromDB(): WeatherData?
}


class RepositoryImp @Inject constructor(
    private val api: DataManagerAPIClient,
    private val dbm: DataBaseManager
) : Repository {

    suspend fun getWeatherData(): WeatherData {
        var dataDB = getWeatherDataFromDB()
        if(dataDB == null){
            dbm.setToDB(FixedData.fixedData)
            dataDB = getWeatherDataFromDB()
        }
        val currTime = System.currentTimeMillis()
        val prevTime = dataDB!!.list12HWeather[0].epochDateTime!! //It's in seconds
        val deltaTime =               // The elapsed time in min, between current time and previously time of call to server, prevTime must to be converted
            (currTime/1000 - prevTime)/60  // from sec to min, while currTime from millisecond to min
        return if (deltaTime > 60) {        // If more than 60 min has elapsed, it makes a new call to server, otherwise get data from Data Base
            val dataApi = getWeatherDataFromApi()
            if (dataApi == null) {        //if I exceeded my 50 calls per day or there is a problem connecting with the service,
                dataDB                         // the Weather data from Api will be null, then return the Weather data from the data base
            } else {
                dbm.updateDataBase(dataApi)
                dataApi
            }
        } else
            dataDB
    }
    override suspend fun getWeatherDataFromApi(): WeatherData? = api.getAllWeatherData()

    override suspend fun getWeatherDataFromDB(): WeatherData? = dbm.getFromDB()

}