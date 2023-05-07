package com.nmincuzzi.ipweather.domain

import com.nmincuzzi.ipweather.domain.Locale
import com.nmincuzzi.ipweather.infrastructure.LocationResponse

/*Extension Functions
* https://kotlinlang.org/docs/reference/extensions.html
*/
fun Locale.toLocationRepresentation() =
    LocationResponse(
        countryCode,
        countryName,
        regionCode,
        regionName,
        city,
        zip,
        latitude,
        longitude
    )