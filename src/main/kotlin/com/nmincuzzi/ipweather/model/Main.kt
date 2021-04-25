package com.nmincuzzi.ipweather.model

/*
*
*"main": {
        "temp": 23.43,
        "feels_like": 22.12,
        "temp_min": 22.78,
        "temp_max": 24.44,
        "pressure": 1017,
        "humidity": 11
    }
*
*
* */

data class Main(
    val temp: Float,
    val feels_like: Float,
    val temp_min: Float,
    val temp_max: Float,
    val pressure: Int,
    val humidity: Int
)
