package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class WeatherForecastsService : WeatherService {

    private val log = LoggerFactory.getLogger(WeatherForecastsService::class.java)

    override fun retrieveWeather(city: String): WeatherRepresentation {
        TODO("Not yet implemented")
    }
}