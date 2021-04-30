package com.nmincuzzi.ipweather.adapter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode
import com.fasterxml.jackson.databind.node.ObjectNode
import com.nmincuzzi.ipweather.model.OpenWeatherRequest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.*
import org.springframework.web.client.RestTemplate

class OpenWeatherMapAdapterTest {

    @MockK
    lateinit var restTemplate: RestTemplate

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun callOpenWeatherApiByCity() {
        /*val openWeatherRequest = OpenWeatherRequest("ignore", "ignore")

        val weatherObject = ObjectMapper().createObjectNode()
        weatherObject.put("id", 800)
        weatherObject.put("main", "Clear")
        weatherObject.put("description", "clear sky")
        weatherObject.put("icon", "01d")
        val weatherArray: ArrayNode = ObjectMapper().createArrayNode()
        weatherArray.add(weatherObject)
        val body: ObjectNode = ObjectMapper().createObjectNode()
        body.put("weather", weatherArray)
        val mainObject = ObjectMapper().createObjectNode()
        weatherObject.put("temp", 23.43)
        weatherObject.put("feels_like", 22.12)
        weatherObject.put("temp_min", 22.78)
        weatherObject.put("temp_max", 24.44)
        weatherObject.put("pressure", 1017)
        weatherObject.put("humidity", 11)
        body.put("weather", mainObject)

        val response = ResponseEntity(body, HttpStatus.OK)
        every {
            restTemplate.exchange(
                "http://api.openweathermap.org/data/2.5/weather?q=ignore&appid=ignore",
                HttpMethod.GET,
                buildHttpEntity(),
                ObjectNode::class.java
            )
        } returns response

        val openWeatherMapAdapter = OpenWeatherMapAdapter(restTemplate)
        openWeatherMapAdapter.execute("ignore", openWeatherRequest)*/
    }

    private fun buildHttpEntity(): HttpEntity<HttpHeaders> {
        val headers = HttpHeaders();
        headers.set("", "")
        return HttpEntity(headers)
    }
}