package com.nmincuzzi.ipweather.controller

import com.nmincuzzi.ipweather.service.CurrentWeatherService
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class LocationControllerTest {

    lateinit var mockMvc: MockMvc

    @MockK
    lateinit var currentBookService: CurrentWeatherService

    @InjectMockKs
    var weatherController = WeatherController()

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.weatherController).build()
    }

    @Test
    //@Throws(Exception::class)
    fun testGetDeviceAuthorizationExpectedResult() {
        /*val bookOne = WeatherModel(id = "id", title = "Il barone rampante", author = "ItaloCalvino", publishedDate = 1925)
        every { currentBookService.retrieveWeather(any()) } returns bookOne
        val uri = URI("/book")

        this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .param("author", "ItaloCalvino")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk)*/
    }

}
