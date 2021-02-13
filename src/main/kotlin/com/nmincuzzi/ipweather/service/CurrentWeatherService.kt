package com.nmincuzzi.ipweather.service

import com.nmincuzzi.ipweather.model.WeatherModel
import com.nmincuzzi.ipweather.adapter.OpenWeatherMapAdapter
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CurrentWeatherService : WeatherService {

    private val log = LoggerFactory.getLogger(CurrentWeatherService::class.java)

    @Autowired
    lateinit var openWeatherMapAdapter: OpenWeatherMapAdapter

    override fun retrieveBooksByAuthor(name: String): WeatherModel {
        log.info("The name of the book 's author: $name")
        val book = openWeatherMapAdapter.getBooksByAuthor(name)
        return retrieveTitleByYear(book, 1925)
    }

    fun retrieveTitleByYear(books: List<WeatherModel>, publishedYear: Int): WeatherModel {
        return books.single { bookModel -> bookModel.publishedDate == publishedYear }
    }
}