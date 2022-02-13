package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.adapter.OpenWeatherMap
import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CurrentWeatherService(private val openWeatherMap: OpenWeatherMap) : WeatherService {

    private val log = LoggerFactory.getLogger(CurrentWeatherService::class.java)

    override fun retrieveWeather(city: String): WeatherRepresentation {
        val openWeatherMap = openWeatherMap.execute(city)
        return openWeatherMap.toWeatherRepresentation()
    }
}