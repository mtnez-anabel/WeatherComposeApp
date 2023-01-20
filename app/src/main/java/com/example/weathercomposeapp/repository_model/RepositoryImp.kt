package com.example.weathercomposeapp.repository_model

import javax.inject.Inject

/**
 * [Repository] manages queries and allows to use multiple backends.
 *
 * It implements the logic for deciding whether to fetch
 * data from the network or use results cached in the local database.
 */
interface Repository {
    //suspend fun getWeatherDataFromApi(): DataManagerAPIClient.WeatherData?


}


class RepositoryImp @Inject constructor(
    private val api: DataManagerAPIClient
) : Repository