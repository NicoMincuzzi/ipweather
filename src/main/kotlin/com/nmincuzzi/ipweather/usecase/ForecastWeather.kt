package com.nmincuzzi.ipweather.usecase

import com.nmincuzzi.ipweather.infrastructure.WeatherRepresentation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ForecastWeather : Weather {

    private val log = LoggerFactory.getLogger(ForecastWeather::class.java)

    override fun retrieveBy(city: String): WeatherRepresentation {
        TODO("Not yet implemented")
    }
}