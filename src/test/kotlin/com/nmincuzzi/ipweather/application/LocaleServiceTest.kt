package com.nmincuzzi.ipweather.application

import com.nmincuzzi.ipweather.infrastructure.IpStackAdapter
import com.nmincuzzi.ipweather.builders.IpStackModelBuilder
import com.nmincuzzi.ipweather.usecase.GetLocation
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
    private lateinit var location: GetLocation

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun retrieveLocaleInRepresentationFormat() {
        val ipStackModel = IpStackModelBuilder().city("Milan").build()
        every { ipStackAdapter.execute("127.0.0.1") } returns ipStackModel

        val result = location.by("127.0.0.1")

        assertEquals("Milan", result.city)
    }
}