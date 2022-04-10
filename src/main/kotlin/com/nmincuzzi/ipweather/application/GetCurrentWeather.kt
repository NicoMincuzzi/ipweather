package com.nmincuzzi.ipweather.application

import com.nmincuzzi.ipweather.adapter.OpenWeatherMap
import com.nmincuzzi.ipweather.infrastructure.WeatherRepresentation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GetCurrentWeather(private val openWeatherMap: OpenWeatherMap) : Weather {

    private val log = LoggerFactory.getLogger(GetCurrentWeather::class.java)

    override fun retrieveBy(city: String): WeatherRepresentation {
        val openWeatherMap = openWeatherMap.execute(city)
        return openWeatherMap.toWeatherRepresentation()
    }
}