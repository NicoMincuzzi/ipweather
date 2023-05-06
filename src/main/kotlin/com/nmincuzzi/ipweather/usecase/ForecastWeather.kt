package com.nmincuzzi.ipweather.usecase

import com.nmincuzzi.ipweather.infrastructure.WeatherResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ForecastWeather : Weather {

    private val log = LoggerFactory.getLogger(ForecastWeather::class.java)

    override fun execute(city: String): WeatherResponse {
        TODO("Not yet implemented")
    }
}