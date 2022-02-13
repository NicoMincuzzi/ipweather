package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.adapter.OpenWeatherMap
import com.nmincuzzi.ipweather.model.Main
import com.nmincuzzi.ipweather.model.OpenWeatherMapModel
import com.nmincuzzi.ipweather.model.Weather
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class CurrentWeatherServiceTest {

    @MockK
    lateinit var openWeatherMap: OpenWeatherMap

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun retrieveWeather() {
        val weather = Weather(123, "Ignore", "Clean Sky", "Ignore")
        val main = Main(0.00f, 0.00f, 0.00f, 0.00f, 0, 0)
        val openWeatherMapModel = OpenWeatherMapModel(weather, main)
        every { openWeatherMap.execute("Milan") } returns openWeatherMapModel

        val currentWeatherService = CurrentWeatherService(openWeatherMap)
        val result = currentWeatherService.retrieveWeather("Milan")
        assertEquals("Clean Sky", result.forecast)
    }
}