package com.nmincuzzi.ipweather.builders

import com.nmincuzzi.ipweather.infrastructure.LocationResponse

class LocationRepresentationBuilder {

    private lateinit var city: String

    fun city(value: String): LocationRepresentationBuilder {
        city = value
        return this
    }

    fun build(): LocationResponse {
        return LocationResponse(
            "IT",
            "Italy",
            "ignore",
            "ignore",
            city,
            "ignore",
            "ignore",
            "ignore"
        )
    }

}
