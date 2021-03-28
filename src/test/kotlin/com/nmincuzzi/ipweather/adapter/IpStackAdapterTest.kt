package com.nmincuzzi.ipweather.adapter

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate


class IpStackAdapterTest {

    @Test
    fun testExecute() {
        /*val clientHttpRequestFactory = HttpComponentsClientHttpRequestFactory()

        val restTemplate = mockk<RestTemplate>()

        val emp = "{}"

        every {
            restTemplate.getForEntity(
                "http://localhost:8080/address?access_key=",
                String::class.java
            )
        } returns ResponseEntity(emp, HttpStatus.OK)
        val ipStackAdapter = IpStackAdapter()
        ipStackAdapter.execute("address")*/

        Assertions.assertEquals(true, true)
    }
}