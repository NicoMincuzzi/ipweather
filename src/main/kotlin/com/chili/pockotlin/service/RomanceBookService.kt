package com.chili.pockotlin.service

import com.chili.pockotlin.model.BookModel
import com.chili.pockotlin.repository.BookRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RomanceBookService : BookService{

    private val log = LoggerFactory.getLogger(RomanceBookService::class.java)

    @Autowired
    lateinit var bookRepository: BookRepository

    override fun retrieveBooksByAuthor(name: String): BookModel {
        log.info("The name of the book 's author: $name")
        val book = bookRepository.getBooksByAuthor(name)
        return retrieveTitleByYear(book, 1925)
    }

    fun retrieveTitleByYear(books: List<BookModel>, publishedYear: Int): BookModel {
        return books.single { bookModel -> bookModel.publishedDate == publishedYear }
    }
}