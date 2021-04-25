package com.nmincuzzi.ipweather.adapter

import com.fasterxml.jackson.databind.ObjectMapper
import com.nmincuzzi.ipweather.model.OpenWeatherRequest
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

class OpenWeatherMapAdapterTest {

    @MockK
    lateinit var restTemplate: RestTemplate

    @Test
    fun callOpenWeatherApiByCity() {
        val openWeatherRequest = OpenWeatherRequest("ignore", "ignore")

        val body = ObjectMapper().createObjectNode()
        body.put("city", "Milan")
        body.put("country_code", "")
        body.put("country_name", "")
        body.put("region_code", "")
        body.put("region_name", "")
        body.put("zip", "")
        body.put("latitude", "")
        body.put("longitude", "")
        val response = ResponseEntity(body, HttpStatus.OK)
        //every { restTemplate.exchange("ignore", GET, entity, ObjectNode::class.java) } returns response

        val openWeatherMapAdapter = OpenWeatherMapAdapter(restTemplate)
        openWeatherMapAdapter.execute("ignore", openWeatherRequest)
    }
}