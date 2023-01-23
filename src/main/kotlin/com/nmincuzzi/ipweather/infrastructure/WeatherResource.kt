package com.nmincuzzi.ipweather.infrastructure

import com.nmincuzzi.ipweather.usecase.GetCurrentWeather
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.util.DigestUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherResource(private val getCurrentWeather: GetCurrentWeather) {

    @GetMapping("/city/{city}/weather", APPLICATION_JSON_VALUE)
    fun weather(@PathVariable(value = "city") city: String): ResponseEntity<WeatherRepresentation> {
        val currentWeather = getCurrentWeather.retrieveBy(city)

        //Client-side Cache Validation
        /*val cacheControl = CacheControl.maxAge(30, TimeUnit.MINUTES)
        return ResponseEntity.ok().cacheControl(cacheControl).body(null)*/

        //Server-side Cache Validation -- ETag
        val weatherHashCode = currentWeather.hashCode().toString()
        val eTag = DigestUtils.md5DigestAsHex(weatherHashCode.toByteArray(Charsets.UTF_8))
        return ResponseEntity.ok().eTag(eTag).body(currentWeather)
    }
}