package com.nmincuzzi.ipweather.infrastructure

data class WeatherResponse(
    val forecast: String,
    val temp: String,
    val feels_like: String,
    val temp_min: String,
    val temp_max: String,
    val humidity: String
)