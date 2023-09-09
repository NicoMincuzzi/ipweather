package com.nmincuzzi.ipweather

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(
    info = Info(
        title = "IP Weather API",
        version = "1.0",
        description = "Documentation about IP Weather endpoints."
    )
)
class IpWeatherApplication

fun main(args: Array<String>) {
    runApplication<IpWeatherApplication>(*args)
}
