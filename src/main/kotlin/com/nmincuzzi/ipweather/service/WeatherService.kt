package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.representation.WeatherRepresentation

interface WeatherService {
    fun retrieveWeather(name: String): WeatherRepresentation
}