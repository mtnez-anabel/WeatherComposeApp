package com.example.weathercomposeapp.repository_model.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CurrentConditionsEntity::class, Each5DaysEntity::class, Each12HoursEntity::class], version = 1, exportSchema = false)
abstract class WeatherDataBase : RoomDatabase() {
    abstract fun getWeatherDao(): WeatherDao
}
