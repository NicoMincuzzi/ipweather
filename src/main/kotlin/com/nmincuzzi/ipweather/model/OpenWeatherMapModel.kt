package com.nmincuzzi.ipweather.model

import com.nmincuzzi.ipweather.representation.WeatherRepresentation

data class OpenWeatherMapModel(val weather: Weather?, val main: Main?) {
    fun toWeatherRepresentation(): WeatherRepresentation {
        return WeatherRepresentation(
            forecast = weather?.description ?: "N/A",
            temp = (main?.temp ?: "N/A").toString(),
            feels_like = (main?.feelsLike ?: "N/A").toString(),
            temp_min = (main?.tempMin ?: "N/A").toString(),
            temp_max = (main?.tempMax ?: "N/A").toString(),
            humidity = (main?.humidity ?: "N/A").toString()
        )
    }
}

