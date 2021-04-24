package com.nmincuzzi.ipweather.builders

import com.nmincuzzi.ipweather.model.IpStackModel

class IpStackModelBuilder {

    private lateinit var city: String

    fun city(city: String): IpStackModelBuilder {
        this.city = city
        return this
    }

    fun build(): IpStackModel {
        return IpStackModel(
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
