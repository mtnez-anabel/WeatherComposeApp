package com.example.weathercomposeapp.repository_model.api

data class Each12H(
    var epochDateTime: Long?,
    var isDaylight: Boolean?,
    val iconPhrase: String?,
    var hourlyTempValue: Double?
)
