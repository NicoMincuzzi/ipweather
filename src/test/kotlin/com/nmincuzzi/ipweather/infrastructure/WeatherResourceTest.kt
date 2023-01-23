package com.nmincuzzi.ipweather.infrastructure

import com.nmincuzzi.ipweather.usecase.GetCurrentWeather
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WeatherResourceTest {

    @MockK
    lateinit var getCurrentWeather: GetCurrentWeather

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun weather() {
        val weatherRepresentation = WeatherRepresentation(
            "Clear sky",
            "temp",
            "feels_like",
            "temp_min",
            "temp_max",
            "humidity"
        )
        every { getCurrentWeather.retrieveBy("Milan") } returns weatherRepresentation

        val weatherResource = WeatherResource(getCurrentWeather)
        val result = weatherResource.weather("Milan")
        assertEquals(200, result.statusCodeValue)
        assertEquals("Clear sky", result.body!!.forecast)
    }
}