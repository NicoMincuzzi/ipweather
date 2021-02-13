package com.nmincuzzi.ipweather.adapter

import com.nmincuzzi.ipweather.model.WeatherModel
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Component
class IpStackAdapter {

    private val log = LoggerFactory.getLogger(IpStackAdapter::class.java)

    fun getBooksByAuthor(authorName: String): List<WeatherModel> {
        val bookOne = WeatherModel(id = UUID.randomUUID().toString(), title = "Moby Dick", author = "HermanMelville", publishedDate = 1979)
        val bookTwo = WeatherModel(id = UUID.randomUUID().toString(), title = "Uno, nessuno e centomila", author = "LuigiPirandello", publishedDate = 1955)
        val bookThree = WeatherModel(id = UUID.randomUUID().toString(), title = "Il barone rampante", author = "ItaloCalvino", publishedDate = 1925)
        val bookFour = WeatherModel(id = UUID.randomUUID().toString(), title = "Uno nessuno centomila", author = "ItaloCalvino", publishedDate = 1935)
        log.info("The Book resources has been correctly retrieved!")
        val books = listOf(bookOne, bookTwo, bookThree, bookFour)
        return books.filter { bookModel -> bookModel.author == authorName }
    }
}