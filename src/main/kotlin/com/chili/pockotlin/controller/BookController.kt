package com.chili.pockotlin.controller

import com.chili.pockotlin.representation.BookRepresentation
import com.chili.pockotlin.service.RomanceBookService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {

    private val log = LoggerFactory.getLogger(BookController::class.java)

    @Autowired
    lateinit var romanceBookService: RomanceBookService

    @GetMapping("/book")
    fun book(@RequestParam(value = "author") name: String): ResponseEntity<BookRepresentation> {
        val filteredBook = romanceBookService.retrieveBooksByAuthor(name)
        log.info("Retrieved books from repository (book: {}).", filteredBook)
        return ResponseEntity.ok(filteredBook.toBookRepresentation())
    }
}