package com.example.weathercomposeapp.repository_model.di
import android.content.Context
import androidx.room.Room
import com.example.weathercomposeapp.repository_model.api.CurrCondAPIService
import com.example.weathercomposeapp.repository_model.api.Forecast12HAPIService
import com.example.weathercomposeapp.repository_model.api.Forecast5DAPIService
import com.example.weathercomposeapp.repository_model.db.WeatherDao
import com.example.weathercomposeapp.repository_model.db.WeatherDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

const val BASE_ULR =
    "https://dataservice.accuweather.com/"

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    /**
     * Builds a Retrofit object with a base URI and a converter factory to build a web service API.
     * The converter tells Retrofit what to do with the data it gets back from the web service.
     * It is using the default timeouts settings.
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_ULR)
            .build()
    }

    /**
     * Instantiates and returns a singleton object that implements [CurrCondAPIService].
     */
    @Singleton
    @Provides
    fun apiCurrentCondition(retrofit: Retrofit): CurrCondAPIService =
        retrofit.create(CurrCondAPIService::class.java)

    /**
     * Instantiates and returns a singleton object that implements [Forecast5DAPIService].
     */
    @Singleton
    @Provides
    fun apiForecast5D(retrofit: Retrofit): Forecast5DAPIService =
        retrofit.create(Forecast5DAPIService::class.java)

    /**
     * Instantiates and returns a singleton object that implements [Forecast12HAPIService].
     */
    @Singleton
    @Provides
    fun apiForecast12H(retrofit: Retrofit): Forecast12HAPIService =
        retrofit.create(Forecast12HAPIService::class.java)



    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context): WeatherDataBase {
        return Room.databaseBuilder(context, WeatherDataBase::class.java, "WeatherRelations")
            .build()
    }

    @Singleton
    @Provides
    fun userDao(db: WeatherDataBase): WeatherDao = db.getWeatherDao()

}