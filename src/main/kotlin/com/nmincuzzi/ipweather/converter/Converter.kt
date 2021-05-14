package com.nmincuzzi.ipweather.converter

import com.nmincuzzi.ipweather.model.IpStackModel
import com.nmincuzzi.ipweather.model.OpenWeatherMapModel
import com.nmincuzzi.ipweather.representation.LocationRepresentation
import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import kotlin.reflect.full.memberProperties

/*Extension Functions
* https://kotlinlang.org/docs/reference/extensions.html
*/
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
fun OpenWeatherMapModel.toWeatherRepresentation() = with(::WeatherRepresentation) {
    val propertiesByName = OpenWeatherMapModel::class.memberProperties.associateBy { it.name }
    callBy(parameters.associateWith { parameter ->
        parameter to when (parameter.name) {
            "forecast" -> "description"
            "temp" -> "temp"
            "feels_like" -> "feels_like"
            "temp_min" -> "temp_min"
            "temp_max" -> "temp_max"
            "humidity" -> "humidity"
            else -> propertiesByName[parameter.name]?.get(this@toWeatherRepresentation)
        }
    })
}