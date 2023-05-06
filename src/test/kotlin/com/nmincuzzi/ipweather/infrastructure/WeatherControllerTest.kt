package com.nmincuzzi.ipweather.infrastructure

import com.nmincuzzi.ipweather.usecase.GetCurrentWeather
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherControllerTest {

    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun getCurrentWeather() = mockk<GetCurrentWeather>()
    }

    @Autowired
    lateinit var getCurrentWeather: GetCurrentWeather

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun `given resource exists with path param when retrieving resource then 200 is returned`() {
        val response = WeatherResponse(
            "Clear sky",
            "temp",
            "feels_like",
            "temp_min",
            "temp_max",
            "humidity"
        )
        every { getCurrentWeather.execute("Milan") } returns response

        val weatherController = WeatherController(getCurrentWeather)
        val result = weatherController.weather("Milan")
        assertTrue(result.statusCode.is2xxSuccessful)
        assertEquals("Clear sky", result.body!!.forecast)
    }

    @Test
    fun `given resource exists when retrieving resource then Etag is also returned`() {
        val weatherResponse = WeatherResponse(
            "Clear sky",
            "temp",
            "feels_like",
            "temp_min",
            "temp_max",
            "humidity"
        )
        every { getCurrentWeather.execute("Bari") } returns weatherResponse

        val response = restTemplate.getForEntity("/city/Bari/weather", WeatherResponse::class.java)

        assertNotNull(response.headers["ETag"])
    }

    @Test
    fun `given resource was retrieved when retrieving again with Etag then NotModified returned`() {
        val weatherResponse = WeatherResponse(
            "Clear sky",
            "temp",
            "feels_like",
            "temp_min",
            "temp_max",
            "humidity"
        )
        every { getCurrentWeather.execute("Bari") } returns weatherResponse
        val response: ResponseEntity<WeatherResponse> =
            restTemplate.getForEntity("/city/Bari/weather", WeatherResponse::class.java)
        val etagValue = response.headers["ETag"]


        val headers = HttpHeaders()
        headers["If-None-Match"] = etagValue
        val entity: HttpEntity<String> = HttpEntity("some body", headers)
        val secondResponse: ResponseEntity<WeatherResponse> =
            restTemplate.exchange("/city/Bari/weather", GET, entity, WeatherResponse::class.java)

        assertTrue(secondResponse.statusCode == HttpStatusCode.valueOf(304))
    }

    @Test
    fun givenResourceWasRetrievedThenModified_whenRetrievingAgainWithEtag_thenResourceIsReturned() {
        var weatherResponse = WeatherResponse(
            "Clear sky",
            "temp",
            "feels_like",
            "temp_min",
            "temp_max",
            "humidity"
        )
        every { getCurrentWeather.execute("Bari") } returns weatherResponse
        val response: ResponseEntity<WeatherResponse> =
            restTemplate.getForEntity("/city/Bari/weather", WeatherResponse::class.java)
        val etagValue = response.headers["ETag"]

        weatherResponse = WeatherResponse(
            "Rain",
            "temp",
            "feels_like",
            "temp_min",
            "temp_max",
            "humidity"
        )
        every { getCurrentWeather.execute("Bari") } returns weatherResponse

        val headers = HttpHeaders()
        headers["If-None-Match"] = etagValue
        val entity: HttpEntity<String> = HttpEntity("some body", headers)
        val secondResponse: ResponseEntity<WeatherResponse> =
            restTemplate.exchange("/city/Bari/weather", GET, entity, WeatherResponse::class.java)

        assertTrue(secondResponse.statusCode == HttpStatusCode.valueOf(200))
    }
}