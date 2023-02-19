package com.nmincuzzi.ipweather.domain

import com.nmincuzzi.ipweather.infrastructure.WeatherResponse

data class OpenWeatherMapModel(val weather: Weather?, val main: Main?) {
    fun toWeatherRepresentation(): WeatherResponse {
        return WeatherResponse(
            forecast = weather?.description ?: "N/A",
            temp = (main?.temp ?: "N/A").toString(),
            feels_like = (main?.feelsLike ?: "N/A").toString(),
            temp_min = (main?.tempMin ?: "N/A").toString(),
            temp_max = (main?.tempMax ?: "N/A").toString(),
            humidity = (main?.humidity ?: "N/A").toString()
        )
    }
}

