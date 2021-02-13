package com.nmincuzzi.ipweather.controller

import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import com.nmincuzzi.ipweather.service.CurrentWeatherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController {

    @Autowired
    lateinit var currentBookService: CurrentWeatherService

    @GetMapping( "/city/{city}/weather", MediaType.APPLICATION_JSON_VALUE)
    fun weather(@PathVariable(value = "city") city: String): ResponseEntity<WeatherRepresentation> {
        val filteredBook = currentBookService.retrieveWeather(city)
        return ResponseEntity.ok().body(null)
    }
}