package com.nmincuzzi.ipweather.application

import com.nmincuzzi.ipweather.builders.IpStackModelBuilder
import com.nmincuzzi.ipweather.domain.GuestIpAddress
import com.nmincuzzi.ipweather.infrastructure.IpStackAdapter
import com.nmincuzzi.ipweather.usecase.GetLocationByIpAddress
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
    private lateinit var location: GetLocationByIpAddress

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun retrieveLocaleInRepresentationFormat() {
        val ipStackModel = IpStackModelBuilder().city("Milan").build()
        every { ipStackAdapter.execute(GuestIpAddress("127.0.0.1")) } returns ipStackModel

        val result = location.execute(GuestIpAddress("127.0.0.1"))

        assertEquals("Milan", result.city)
    }
}