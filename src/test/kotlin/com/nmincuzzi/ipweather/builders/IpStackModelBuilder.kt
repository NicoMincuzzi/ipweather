package com.nmincuzzi.ipweather.builders

import com.nmincuzzi.ipweather.domain.Locale

class IpStackModelBuilder {

    private lateinit var city: String

    fun city(city: String): IpStackModelBuilder {
        this.city = city
        return this
    }

    fun build(): Locale {
        return Locale(
            "ignore",
            "ignore",
            "ignore",
            "ignore",
            city,
            "ignore",
            "ignore",
            "ignore"
        )

    }

}
