package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.adapter.OpenWeatherMapAdapter
import com.nmincuzzi.ipweather.model.OpenWeatherMapModel
import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CurrentWeatherService(private val openWeatherMapAdapter: OpenWeatherMapAdapter) : WeatherService {

    private val log = LoggerFactory.getLogger(CurrentWeatherService::class.java)

    override fun retrieveWeather(city: String): WeatherRepresentation {
        val openWeatherMap = openWeatherMapAdapter.execute(city)
        return toWeatherRepresentation(openWeatherMap)
    }

    private fun toWeatherRepresentation(openWeatherMap: OpenWeatherMapModel): WeatherRepresentation {
      return WeatherRepresentation(
          forecast = openWeatherMap.weather?.description ?: "N/A",
          temp = (openWeatherMap.main?.temp ?: "N/A").toString(),
          feels_like= (openWeatherMap.main?.feelsLike ?: "N/A").toString(),
          temp_min = (openWeatherMap.main?.tempMin ?: "N/A").toString(),
          temp_max = (openWeatherMap.main?.tempMax ?: "N/A").toString(),
          humidity = (openWeatherMap.main?.humidity ?: "N/A").toString()
      )
    }

}