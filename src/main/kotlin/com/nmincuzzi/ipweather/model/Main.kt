package com.nmincuzzi.ipweather.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Main(
    @JsonProperty("temp") val temp: Float,
    @JsonProperty("feels_like") val feelsLike: Float,
    @JsonProperty("temp_min") val tempMin: Float,
    @JsonProperty("temp_max") val tempMax: Float,
    @JsonProperty("pressure") val pressure: Int,
    @JsonProperty("humidity") val humidity: Int
)
