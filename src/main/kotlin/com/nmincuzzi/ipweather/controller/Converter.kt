package com.nmincuzzi.ipweather.controller

import com.nmincuzzi.ipweather.model.WeatherModel

import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import kotlin.reflect.full.memberProperties

/*Extension Functions
* https://kotlinlang.org/docs/reference/extensions.html
*/
fun WeatherModel.toBookRepresentation() = WeatherRepresentation(
        id = id,
        name = title,
        year = publishedDate
)

/*Kotlin Reflection
* https://kotlinlang.org/docs/reference/reflection.html
*/
fun WeatherModel.toUserViewReflection() = with(::WeatherRepresentation) {
    val propertiesByName = com.nmincuzzi.ipweather.model.WeatherModel::class.memberProperties.associateBy { it.name }
    /*callBy(parameters.associateWith { parameter ->
        when (parameter.name) {
            WeatherRepresentation::id.name -> id
            WeatherRepresentation::name.name -> name
            WeatherRepresentation::year.name -> publishedDate
            else -> propertiesByName[parameter.name]?.get(this@toUserViewReflection)
        }
    })*/
}