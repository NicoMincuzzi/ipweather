package com.chili.pockotlin.service

import com.chili.pockotlin.model.BookModel

interface BookService {
    fun retrieveBooksByAuthor(name: String): BookModel
}