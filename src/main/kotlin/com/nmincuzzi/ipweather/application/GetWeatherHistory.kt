package com.nmincuzzi.ipweather.application

import com.nmincuzzi.ipweather.infrastructure.WeatherRepresentation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GetWeatherHistory : Weather {

    private val log = LoggerFactory.getLogger(GetWeatherHistory::class.java)

    override fun retrieveBy(city: String): WeatherRepresentation {
        TODO("Not yet implemented")
    }
}