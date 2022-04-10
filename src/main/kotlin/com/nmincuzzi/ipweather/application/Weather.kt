package com.nmincuzzi.ipweather.application

import com.nmincuzzi.ipweather.infrastructure.WeatherRepresentation

interface Weather {
    fun retrieveBy(city: String): WeatherRepresentation
}