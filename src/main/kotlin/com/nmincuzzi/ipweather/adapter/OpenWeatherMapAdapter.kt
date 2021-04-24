package com.nmincuzzi.ipweather.adapter

import com.fasterxml.jackson.databind.node.ObjectNode
import com.nmincuzzi.ipweather.expection.GenericError
import com.nmincuzzi.ipweather.model.OpenWeatherMapModel
import com.nmincuzzi.ipweather.model.OpenWeatherRequest
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class OpenWeatherMapAdapter(val restTemplate: RestTemplate) {

    fun execute(city: String, openWeatherRequest: OpenWeatherRequest): OpenWeatherMapModel {
        val url = ""

        val headers = HttpHeaders();
        headers.set("x-rapidapi-key", "");
        headers.set("x-rapidapi-host", "");

        val entity = HttpEntity<HttpHeaders>(headers)

        val response = restTemplate.exchange(url, GET, entity, ObjectNode::class.java)

        if (response.statusCode.is2xxSuccessful && response.body != null) {
            return toModel(response.body)
        }
        throw GenericError()
    }

    fun toModel(response: ObjectNode?): OpenWeatherMapModel {
        return OpenWeatherMapModel(response?.get("id").toString())
    }
}