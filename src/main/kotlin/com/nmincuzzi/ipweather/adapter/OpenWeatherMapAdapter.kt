package com.nmincuzzi.ipweather.adapter

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.treeToValue
import com.nmincuzzi.ipweather.expection.GenericError
import com.nmincuzzi.ipweather.model.Main
import com.nmincuzzi.ipweather.model.OpenWeatherMapModel
import com.nmincuzzi.ipweather.model.OpenWeatherRequest
import com.nmincuzzi.ipweather.model.Weather
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class OpenWeatherMapAdapter(val restTemplate: RestTemplate) {

    fun execute(city: String, openWeatherRequest: OpenWeatherRequest): OpenWeatherMapModel {
        val url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + openWeatherRequest.appId
        val entity = buildHttpEntity()
        val response = restTemplate.exchange(url, GET, entity, JsonNode::class.java)

        if (response.statusCode.is2xxSuccessful && response.body != null) {
            return toModel(response.body!!)
        }
        throw GenericError()
    }

    private fun buildHttpEntity(): HttpEntity<HttpHeaders> {
        val headers = HttpHeaders();
        headers.set("", "")
        return HttpEntity(headers)
    }

    fun toModel(responseBody: JsonNode): OpenWeatherMapModel {
        val weatherNode: Weather? = ObjectMapper().treeToValue(responseBody.get("weather")[0])
        val mainNode: Main? = ObjectMapper().treeToValue(responseBody.get("main"))

        return OpenWeatherMapModel(weatherNode, mainNode)
    }
}