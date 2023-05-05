package com.nmincuzzi.ipweather.infrastructure

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.treeToValue
import com.nmincuzzi.ipweather.domain.Main
import com.nmincuzzi.ipweather.domain.OpenWeatherMapModel
import com.nmincuzzi.ipweather.domain.Weather
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class OpenWeatherMapAdapter(
    private val restTemplate: RestTemplate,
    @Value("\${openstackmap.url}") private val host: String,
    @Value("\${openstackmap.app_id}") private val appId: String
) {

    fun execute(city: String): OpenWeatherMapModel {
        val url = "$host?q=$city&appid=$appId&units=metric"
        val entity = buildHttpEntity()
        val response = restTemplate.exchange(url, GET, entity, ObjectNode::class.java)

        if (response.statusCode.is2xxSuccessful && response.body != null) {
            return toModel(response.body!!)
        }
        throw RuntimeException()
    }

    private fun buildHttpEntity(): HttpEntity<HttpHeaders> {
        val headers = HttpHeaders()
        headers.set("", "")
        return HttpEntity(headers)
    }

    fun toModel(responseBody: JsonNode): OpenWeatherMapModel {
        val weatherNode: Weather? = ObjectMapper().treeToValue(responseBody.get("weather")[0])
        val mainNode: Main? = ObjectMapper().treeToValue(responseBody.get("main"))

        return OpenWeatherMapModel(weatherNode, mainNode)
    }
}