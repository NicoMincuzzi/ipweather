package com.chili.pockotlin.service

import com.chili.pockotlin.model.BookModel
import com.chili.pockotlin.repository.BookRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class BookModelServiceTest {

    @MockK
    lateinit var bookRepository: BookRepository

    @InjectMockKs
    var bookService = RomanceBookService()

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun testRetrieveAllBooks() {
        val bookOne = BookModel(id = "id", title = "Il barone rampante", author = "ItaloCalvino", publishedDate = 1925)
        val bookTwo = BookModel(id = "id", title = "Uno nessuno centomila", author = "ItaloCalvino", publishedDate = 1935)
        val books = listOf(bookOne, bookTwo)
        every { bookRepository.getBooksByAuthor(any()) } returns books
        val expected = BookModel(id = "id", title = "Il barone rampante", author = "ItaloCalvino", publishedDate = 1925)
        val result = bookService.retrieveBooksByAuthor("ItaloCalvino")
        Assertions.assertEquals(expected, result)
    }
}