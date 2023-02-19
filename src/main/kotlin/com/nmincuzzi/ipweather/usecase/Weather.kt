package com.nmincuzzi.ipweather.usecase

import com.nmincuzzi.ipweather.infrastructure.WeatherResponse

interface Weather {
    fun retrieveBy(city: String): WeatherResponse
}