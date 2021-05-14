package com.nmincuzzi.ipweather.controller

import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import com.nmincuzzi.ipweather.service.CurrentWeatherService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class WeatherControllerTest {

    @MockK
    lateinit var currentWeatherService: CurrentWeatherService

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
        every { currentWeatherService.retrieveWeather("Milan") } returns weatherRepresentation

        val weatherController = WeatherController(currentWeatherService)
        val result = weatherController.weather("Milan")
        assertEquals(200, result.statusCodeValue)
        assertEquals("Clear sky", result.body!!.forecast)
    }
}