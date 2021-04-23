package com.nmincuzzi.ipweather.controller

import com.nmincuzzi.ipweather.representation.LocationRepresentation
import com.nmincuzzi.ipweather.service.LocationService
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.mock.web.MockHttpServletRequest

class LocationControllerTest {

    @MockK
    lateinit var locationService: LocationService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testGetDeviceAuthorizationExpectedResult() {
        val location = LocationRepresentation("IT", "Italy", "ignore", "ignore", "Milan", "ignore", "ignore", "ignore")

        every { locationService.retrieveIpAddress(null, "127.0.0.1") } returns "127.0.0.1"
        every { locationService.retrieveLocation("127.0.0.1") } returns location

        val locationController = LocationController(locationService)
        val result = locationController.location(MockHttpServletRequest())
        assertEquals("Milan", result.city)
    }

}
