package com.example.weathercomposeapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathercomposeapp.repository_model.RepositoryImp
import com.example.weathercomposeapp.repository_model.WeatherData
import com.example.weathercomposeapp.repository_model.db.FixedData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: RepositoryImp) : ViewModel() {
    val weatherModel = MutableLiveData<WeatherData>()
    fun onCreate() {
        viewModelScope.launch {
            //val result = repository.getWeatherData()
            val result = FixedData.fixedData
            weatherModel.postValue(result)
        }
    }
}