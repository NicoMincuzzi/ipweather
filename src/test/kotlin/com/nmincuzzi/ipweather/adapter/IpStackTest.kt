package com.nmincuzzi.ipweather.adapter

import com.fasterxml.jackson.databind.node.ObjectNode
import com.nmincuzzi.ipweather.builders.IpStackResponseBodyBuilder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate


class IpStackTest {

    @MockK
    lateinit var restTemplate: RestTemplate

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun callIpStackEndpointsToRetrieveCity() {
        val body = IpStackResponseBodyBuilder().city("Milan").build()

        val response = ResponseEntity(body, HttpStatus.OK)

        every {
            restTemplate.getForEntity(
                "http://localhost:8080/127.0.0.1?access_key=123",
                ObjectNode::class.java
            )
        } returns response

        val ipStack =
            IpStack(restTemplate, "http://localhost:8080/", "123")
        val result = ipStack.execute("127.0.0.1")
        assertEquals("\"Milan\"", result.city)
    }
}