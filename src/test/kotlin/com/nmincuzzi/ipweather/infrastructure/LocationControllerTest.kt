package com.nmincuzzi.ipweather.infrastructure

import com.nmincuzzi.ipweather.usecase.GetLocation
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
    lateinit var locationService: GetLocation

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun retrieveCityGivenAIpAddress() {
        val location = LocationRepresentationBuilder().city("Milan").build()

        every { locationService.by("127.0.0.1") } returns location

        val locationController =
            LocationController(locationService)
        val result = locationController.location(MockHttpServletRequest())

        assertEquals("Milan", result.city)
    }

}
