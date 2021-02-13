package com.nmincuzzi.ipweather.adapter

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class OpenWeatherMapAdapter {

    private val log = LoggerFactory.getLogger(OpenWeatherMapAdapter::class.java)

    fun execute(authorName: String) {
        /*val client = OkHttpClient()

        val request = Request.Builder()
                .url("https://community-open-weather-map.p.rapidapi.com/weather?q=London%2Cuk&lat=0&lon=0&callback=test&id=2172797&lang=null&units=%22metric%22%20or%20%22imperial%22&mode=xml%2C%20html")
                .get()
                .addHeader("x-rapidapi-key", "f531619183mshd2a9e647bcd2ae2p1d5b6fjsn0ec1929f8f17")
                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .build()

        val response = client.newCall(request).execute()*/
    }
}