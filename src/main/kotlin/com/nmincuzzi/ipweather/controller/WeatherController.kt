package com.nmincuzzi.ipweather.controller

import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import com.nmincuzzi.ipweather.service.CurrentWeatherService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController {

    private val log = LoggerFactory.getLogger(WeatherController::class.java)

    @Autowired
    lateinit var currentBookService: CurrentWeatherService

    @GetMapping("/book")
    fun book(@RequestParam(value = "author") name: String): ResponseEntity<WeatherRepresentation> {
        val filteredBook = currentBookService.retrieveBooksByAuthor(name)
        log.info("Retrieved books from repository (book: {}).", filteredBook)
        return ResponseEntity.ok(filteredBook.toBookRepresentation())
    }
}