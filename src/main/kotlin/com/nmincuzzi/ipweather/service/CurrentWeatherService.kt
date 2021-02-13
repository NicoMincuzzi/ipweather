package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CurrentWeatherService : WeatherService {

    private val log = LoggerFactory.getLogger(CurrentWeatherService::class.java)

    override fun retrieveWeather(name: String): WeatherRepresentation {
        TODO("Not yet implemented")
    }

}