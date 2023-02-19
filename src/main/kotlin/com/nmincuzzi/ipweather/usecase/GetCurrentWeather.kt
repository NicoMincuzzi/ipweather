package com.nmincuzzi.ipweather.usecase

import com.nmincuzzi.ipweather.infrastructure.OpenWeatherMapAdapter
import com.nmincuzzi.ipweather.infrastructure.WeatherResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GetCurrentWeather(private val openWeatherMapAdapter: OpenWeatherMapAdapter) : Weather {

    private val log = LoggerFactory.getLogger(GetCurrentWeather::class.java)

    override fun retrieveBy(city: String): WeatherResponse {
        val openWeatherMap = openWeatherMapAdapter.execute(city)
        return openWeatherMap.toWeatherRepresentation()
    }
}