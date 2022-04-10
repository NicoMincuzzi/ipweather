package com.nmincuzzi.ipweather.builders

import com.nmincuzzi.ipweather.infrastructure.LocationRepresentation

class LocationRepresentationBuilder {

    private lateinit var city: String

    fun city(value: String): LocationRepresentationBuilder {
        city = value
        return this
    }

    fun build(): LocationRepresentation {
        return LocationRepresentation(
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
