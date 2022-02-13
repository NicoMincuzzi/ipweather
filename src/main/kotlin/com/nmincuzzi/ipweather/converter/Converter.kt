package com.nmincuzzi.ipweather.converter

import com.nmincuzzi.ipweather.model.IpStackModel
import com.nmincuzzi.ipweather.representation.LocationRepresentation

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