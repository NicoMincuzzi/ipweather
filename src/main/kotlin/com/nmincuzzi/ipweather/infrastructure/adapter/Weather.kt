package com.nmincuzzi.ipweather.infrastructure.adapter

import com.fasterxml.jackson.annotation.JsonProperty

data class Weather(
    @JsonProperty("id") val id: Int,
    @JsonProperty("main") val main: String,
    @JsonProperty("description") val description: String,
    @JsonProperty("icon") val icon: String
    )
