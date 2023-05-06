package com.nmincuzzi.ipweather.usecase

import com.nmincuzzi.ipweather.infrastructure.OpenWeatherMapAdapter
import com.nmincuzzi.ipweather.infrastructure.WeatherResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GetCurrentWeather(private val openWeatherMapAdapter: OpenWeatherMapAdapter) : Weather {

    private val log: Logger = LoggerFactory.getLogger(GetCurrentWeather::class.java)

    override fun retrieveBy(city: String): WeatherResponse {
        val openWeatherMap = openWeatherMapAdapter.execute(city)
        log.info("Current weather in {}: {}", city, openWeatherMap)

        return openWeatherMap.toWeatherRepresentation()
    }
}