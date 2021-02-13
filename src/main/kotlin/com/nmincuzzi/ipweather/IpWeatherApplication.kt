package com.nmincuzzi.ipweather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IpWeatherApplication

fun main(args: Array<String>) {
	runApplication<IpWeatherApplication>(*args)
}
