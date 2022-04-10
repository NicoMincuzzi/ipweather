package com.nmincuzzi.ipweather.application

import com.nmincuzzi.ipweather.adapter.OpenWeatherMap
import com.nmincuzzi.ipweather.domain.Main
import com.nmincuzzi.ipweather.domain.OpenWeatherMapModel
import com.nmincuzzi.ipweather.domain.Weather
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class GetCurrentWeatherTest {

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

        val getCurrentWeather = GetCurrentWeather(openWeatherMap)
        val result = getCurrentWeather.retrieveBy("Milan")
        assertEquals("Clean Sky", result.forecast)
    }
}