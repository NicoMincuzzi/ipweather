package com.nmincuzzi.ipweather.application

import com.nmincuzzi.ipweather.domain.Main
import com.nmincuzzi.ipweather.domain.OpenWeatherMapModel
import com.nmincuzzi.ipweather.domain.Weather
import com.nmincuzzi.ipweather.infrastructure.OpenWeatherMapAdapter
import com.nmincuzzi.ipweather.usecase.GetCurrentWeather
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetCurrentWeatherTest {

    @MockK
    lateinit var openWeatherMapAdapter: OpenWeatherMapAdapter

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun retrieveWeather() {
        val weather = Weather(123, "Ignore", "Clean Sky", "Ignore")
        val main = Main(0.00f, 0.00f, 0.00f, 0.00f, 0, 0)
        val openWeatherMapModel = OpenWeatherMapModel(weather, main)
        every { openWeatherMapAdapter.execute("Milan") } returns openWeatherMapModel

        val getCurrentWeather = GetCurrentWeather(openWeatherMapAdapter)
        val result = getCurrentWeather.execute("Milan")
        assertEquals("Clean Sky", result.forecast)
    }
}