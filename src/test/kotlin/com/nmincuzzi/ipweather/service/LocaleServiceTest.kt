package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.adapter.IpStackAdapter
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LocaleServiceTest {

    @MockK
    private lateinit var ipStackAdapter:IpStackAdapter

    @InjectMockKs
    private lateinit var locationService: LocationService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testRetrieveIpAddress_With_xForwardedForHeader() {
        val xForwardedForHeader = "mockXForwardedForHeader"
        val remoteAddr = "mockRemoteAddr"
        val result = locationService.retrieveIpAddress(xForwardedForHeader, remoteAddr)
        assertEquals(xForwardedForHeader, result)
    }

    @Test
    fun testRetrieveIpAddress_Empty_xForwardedForHeader() {
        val xForwardedForHeader = ""
        val remoteAddr = "mockRemoteAddr"
        val result = locationService.retrieveIpAddress(xForwardedForHeader, remoteAddr)
        assertEquals(remoteAddr, result)
    }

    @Test
    fun testRetrieveIpAddress_WhiteSpace_xForwardedForHeader() {
        val xForwardedForHeader = " "
        val remoteAddr = "mockRemoteAddr"
        val result = locationService.retrieveIpAddress(xForwardedForHeader, remoteAddr)
        assertEquals(remoteAddr, result)
    }
}