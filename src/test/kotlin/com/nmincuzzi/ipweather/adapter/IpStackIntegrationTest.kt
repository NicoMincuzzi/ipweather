package com.nmincuzzi.ipweather.adapter

import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig
import com.github.tomakehurst.wiremock.junit5.WireMockExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.springframework.web.client.RestTemplate


class DeclarativeWireMockTest {
    @RegisterExtension
    var wireMockExtension: WireMockExtension = WireMockExtension.newInstance()
        .options(wireMockConfig().dynamicPort())
        .build()

    @Test
    fun retrieveLocationByIpAddress() {
        val port: Int = wireMockExtension.runtimeInfo.httpPort

        wireMockExtension.stubFor(
            get(urlEqualTo("/127.0.0.1?access_key=123"))
                .willReturn(
                    aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{\"country_code\":\"country_code\",\"country_name\":\"country_name\",\"region_code\":\"region_code\",\"region_name\":\"region_name\",\"city\":\"city\",\"zip\":\"zip\",\"latitude\":\"latitude\",\"longitude\":\"longitude\"}")
                )
        )


        val adapter = IpStack(RestTemplate(), "http://localhost:$port/", "123")
        val result = adapter.execute("127.0.0.1")
        Assertions.assertEquals("\"city\"", result.city)
    }
}