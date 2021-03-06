package com.nmincuzzi.ipweather.controller

import com.nmincuzzi.ipweather.representation.WeatherRepresentation
import com.nmincuzzi.ipweather.service.CurrentWeatherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.CacheControl
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.DigestUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

@RestController
class WeatherController {

    @Autowired
    lateinit var currentBookService: CurrentWeatherService

    @GetMapping("/city/{city}/weather", MediaType.APPLICATION_JSON_VALUE)
    fun weather(@PathVariable(value = "city") city: String): ResponseEntity<WeatherRepresentation> {
        val filteredBook = currentBookService.retrieveWeather(city)

        //Client-side Cache Validation
        /*val cacheControl = CacheControl.maxAge(30, TimeUnit.MINUTES)
        return ResponseEntity.ok().cacheControl(cacheControl).body(null)*/

        //Server-side Cache Validation -- ETag
        val weatherHashCode = filteredBook.hashCode().toString()
        val eTag = DigestUtils.md5DigestAsHex(weatherHashCode.toByteArray(Charsets.UTF_8))
        return ResponseEntity.ok().eTag(eTag).body(null)


    }
}