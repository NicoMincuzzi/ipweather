package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.model.WeatherModel

interface WeatherService {
    fun retrieveBooksByAuthor(name: String): WeatherModel
}