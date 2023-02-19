package com.nmincuzzi.ipweather.usecase

import com.nmincuzzi.ipweather.infrastructure.WeatherResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class GetWeatherHistory : Weather {

    private val log = LoggerFactory.getLogger(GetWeatherHistory::class.java)

    override fun retrieveBy(city: String): WeatherResponse {
        TODO("Not yet implemented")
    }
}