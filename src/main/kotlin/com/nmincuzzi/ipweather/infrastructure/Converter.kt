package com.nmincuzzi.ipweather.converter

import com.nmincuzzi.ipweather.domain.Locale
import com.nmincuzzi.ipweather.infrastructure.LocationRepresentation

/*Extension Functions
* https://kotlinlang.org/docs/reference/extensions.html
*/
fun Locale.toLocationRepresentation() =
    LocationRepresentation(
        countryCode,
        countryName,
        regionCode,
        regionName,
        city,
        zip,
        latitude,
        longitude
    )