package com.nmincuzzi.ipweather.infrastructure

import com.nmincuzzi.ipweather.usecase.GetCurrentWeather
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherController(private val getCurrentWeather: GetCurrentWeather) {

    @GetMapping("/city/{city}/weather", APPLICATION_JSON_VALUE)
    fun weather(@PathVariable(value = "city") city: String): ResponseEntity<WeatherResponse> {
        val currentWeather = getCurrentWeather.execute(city)

        //Client-side Cache Validation
        /*val cacheControl = CacheControl.maxAge(30, TimeUnit.MINUTES)
        return ResponseEntity.ok().cacheControl(cacheControl).body(null)*/

        return ResponseEntity.ok().body(currentWeather)
    }
}