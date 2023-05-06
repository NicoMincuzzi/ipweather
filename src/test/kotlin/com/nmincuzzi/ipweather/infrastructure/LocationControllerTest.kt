package com.nmincuzzi.ipweather.infrastructure

import com.nmincuzzi.ipweather.usecase.GetLocationByIpAddress
import com.nmincuzzi.ipweather.builders.LocationRepresentationBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.mock.web.MockHttpServletRequest

class LocationControllerTest {

    @MockK
    lateinit var locationService: GetLocationByIpAddress

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun retrieveCityGivenAIpAddress() {
        val location = LocationRepresentationBuilder().city("Milan").build()
        every { locationService.execute("0.0.0.0") } returns location
        val locationController = LocationController(locationService)
        val httpServletRequest = MockHttpServletRequest()
        httpServletRequest.addHeader("X-FORWARDED-FOR", "0.0.0.0, 1.1.1.1")

        val result = locationController.location(httpServletRequest)

        assertEquals("Milan", result.city)
    }

}
