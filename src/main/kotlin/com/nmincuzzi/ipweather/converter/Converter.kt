package com.nmincuzzi.ipweather.controller

import com.nmincuzzi.ipweather.model.IpStackModel
import com.nmincuzzi.ipweather.model.OpenWeatherMapModel
import com.nmincuzzi.ipweather.representation.LocationRepresentation
import com.nmincuzzi.ipweather.representation.WeatherRepresentation

/*Extension Functions
* https://kotlinlang.org/docs/reference/extensions.html
*/
fun OpenWeatherMapModel.toBookRepresentation() = WeatherRepresentation(
    id = id
)

fun IpStackModel.toLocationRepresentation() = LocationRepresentation(
    countryCode,
    countryName,
    regionCode,
    regionName,
    city,
    zip,
    latitude,
    longitude
)

/*Kotlin Reflection
* https://kotlinlang.org/docs/reference/reflection.html
*/
/*fun IpStackModel.toLocationRepresentation() = with(::LocationRepresentation) {
    val propertiesByName = IpStackModel::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        parameter to when (parameter.name) {
            "countryCode" -> "countryCode"
            "countryName" -> "countryName"
            "regionCode" -> "regionCode"
            "regionName" -> "regionName"
            "city" -> "city"
            "zip" -> "zip"
            "latitude" -> "latitude"
            "longitude" -> "longitude"
            else -> propertiesByName[parameter.name]?.get(this@toLocationRepresentation)
        }
    })
}*/