package com.nmincuzzi.ipweather.service

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LocaleServiceTest {

    @InjectMockKs
    var bookService = CurrentWeatherService()

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun testRetrieveAllBooks() {
    }
}