package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.model.WeatherModel
import com.nmincuzzi.ipweather.adapter.IpStackAdapter
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class LocaleServiceTest {

    @MockK
    lateinit var ipStackAdapter: IpStackAdapter

    @InjectMockKs
    var bookService = CurrentWeatherService()

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun testRetrieveAllBooks() {
        val bookOne = WeatherModel(id = "id", title = "Il barone rampante", author = "ItaloCalvino", publishedDate = 1925)
        val bookTwo = WeatherModel(id = "id", title = "Uno nessuno centomila", author = "ItaloCalvino", publishedDate = 1935)
        val books = listOf(bookOne, bookTwo)
        every { ipStackAdapter.getBooksByAuthor(any()) } returns books
        val expected = WeatherModel(id = "id", title = "Il barone rampante", author = "ItaloCalvino", publishedDate = 1925)
        val result = bookService.retrieveBooksByAuthor("ItaloCalvino")
        Assertions.assertEquals(expected, result)
    }
}