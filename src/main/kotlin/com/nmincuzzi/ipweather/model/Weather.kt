package com.nmincuzzi.ipweather.model
/*
*
* "weather": [
        {
            "id": 800,
            "main": "Clear",
            "description": "clear sky",
            "icon": "01d"
        }
    ]
*
* */
data class Weather(val main: String, val description: String)
