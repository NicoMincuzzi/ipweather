package com.nmincuzzi.ipweather.builders

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode

class IpStackResponseBodyBuilder {

    private lateinit var city: String

    fun city(value: String): IpStackResponseBodyBuilder {
        this.city = value
        return this
    }

    fun build(): ObjectNode {
        val body = ObjectMapper().createObjectNode()
        body.put("city", "Milan")
        body.put("country_code", "ignore")
        body.put("country_name", "ignore")
        body.put("region_code", "ignore")
        body.put("region_name", "ignore")
        body.put("zip", "ignore")
        body.put("latitude", "ignore")
        body.put("longitude", "ignore")
        return body
    }

}
