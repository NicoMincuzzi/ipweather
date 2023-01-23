package com.nmincuzzi.ipweather.usecase

import com.nmincuzzi.ipweather.infrastructure.WeatherRepresentation

interface Weather {
    fun retrieveBy(city: String): WeatherRepresentation
}