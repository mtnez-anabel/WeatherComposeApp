package com.example.weathercomposeapp.repository_model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val key = "C1uAGGDch94QSJ6FSiv5X8J72mwv1cp9"
private const val myLocationKey = "2579865"
const val BASE_ULR =
    "https://dataservice.accuweather.com/"

/**
 * Interface that defines a GET HTTP operation to get the Current Condition from accuweather.com server.
 */
interface CurrCondAPIService {
    @GET("currentconditions/v1/$myLocationKey?apikey=$key&details=true")
    suspend fun getCurrentCondition(): Response<List<CurrentConditionData>>
}
/**
 * Interface that defines a GET HTTP operation to get the 5 Days Forecast from accuweather.com server.
 */
interface Forecast5DAPIService {
    @GET("forecasts/v1/daily/5day/$myLocationKey?apikey=$key&metric=true")
    suspend fun getForecast5D(): Response<Forecast5DData>
}
/**
 * Interface that defines a GET HTTP operation to get the 12 Hours Forecast from accuweather.com server.
 */
interface Forecast12HAPIService {
    @GET("forecasts/v1/hourly/12hour/$myLocationKey?apikey=$key&metric=true")
    suspend fun getForecast12H(): Response<List<Forecast12HData>>
}