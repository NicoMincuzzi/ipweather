package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HistoricalWeatherService : WeatherService {

    private val log = LoggerFactory.getLogger(HistoricalWeatherService::class.java)

    override fun retrieveWeather(city: String): WeatherRepresentation {
        TODO("Not yet implemented")
    }
}