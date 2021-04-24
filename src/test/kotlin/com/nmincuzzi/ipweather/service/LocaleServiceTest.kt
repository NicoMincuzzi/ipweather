package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.adapter.IpStackAdapter
import com.nmincuzzi.ipweather.builders.IpStackModelBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LocaleServiceTest {

    @MockK
    private lateinit var ipStackAdapter: IpStackAdapter

    @InjectMockKs
    private lateinit var locationService: LocationService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun retrieveIpAddress_With_xForwardedForHeader() {
        val xForwardedForHeader = "xForwardedForHeader"
        val remoteAddr = "remoteAddr"

        val result = locationService.retrieveIpAddress(xForwardedForHeader, remoteAddr)

        assertEquals(xForwardedForHeader, result)
    }

    @Test
    fun retrieveIpAddress_Empty_xForwardedForHeader() {
        val xForwardedForHeader = ""
        val remoteAddr = "remoteAddr"

        val result = locationService.retrieveIpAddress(xForwardedForHeader, remoteAddr)

        assertEquals(remoteAddr, result)
    }

    @Test
    fun retrieveIpAddress_WhiteSpace_xForwardedForHeader() {
        val xForwardedForHeader = " "
        val remoteAddr = "remoteAddr"

        val result = locationService.retrieveIpAddress(xForwardedForHeader, remoteAddr)

        assertEquals(remoteAddr, result)
    }

    @Test
    fun retrieveLocaleInRepresentationFormat() {
        val ipStackModel = IpStackModelBuilder().city("Milan").build()

        every { ipStackAdapter.execute("127.0.0.1") } returns ipStackModel

        val result = locationService.retrieveLocation("127.0.0.1")

        assertEquals("Milan", result.city)
    }
}