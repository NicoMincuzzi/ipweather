package com.nmincuzzi.ipweather.adapter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate


class IpStackAdapterTest {

    @MockK
    lateinit var restTemplate: RestTemplate

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun callIpStackEndpointsToRetrieveCity() {
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

        every {
            restTemplate.getForEntity(
                "http://localhost:8080/127.0.0.1?access_key=",
                ObjectNode::class.java
            )
        } returns response

        val ipStackAdapter = IpStackAdapter(restTemplate)
        val result = ipStackAdapter.execute("127.0.0.1")
        assertEquals("\"Milan\"", result.city)
    }
}