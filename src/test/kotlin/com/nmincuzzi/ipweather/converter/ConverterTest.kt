package com.nmincuzzi.ipweather.converter

import com.nmincuzzi.ipweather.domain.Locale
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ConverterTest {

    @Test
    fun testToLocationRepresentation() {

        val ipStackModel = Locale(
            "countryCode",
            "countryName",
            "regionCode",
            "regionName",
            "city",
            "zip",
            "latitude",
            "longitude"
        )
        val result = ipStackModel.toLocationRepresentation()
        assertAll("result",
                { assertEquals("countryCode", result.countryCode) },
                { assertEquals("countryName", result.countryName) },
                { assertEquals("regionCode", result.regionCode) },
                { assertEquals("regionName", result.regionName) },
                { assertEquals("city", result.city) },
                { assertEquals("zip", result.zip) },
                { assertEquals("latitude", result.latitude) },
                { assertEquals("longitude", result.longitude) },
        )
    }
}