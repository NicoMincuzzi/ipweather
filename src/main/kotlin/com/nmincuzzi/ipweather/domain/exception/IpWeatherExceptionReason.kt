package com.nmincuzzi.ipweather.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR


class IpWeatherExceptionReason(
    private val message: String,
    private val httpStatus: HttpStatus = INTERNAL_SERVER_ERROR
) {

    private val code = IpWeatherExceptionReason::class.java.simpleName

    fun getCode(): String {
        return code
    }

    fun getMessage(): String {
        return this.message
    }

    fun getHttpStatus(): HttpStatus {
        return this.httpStatus
    }
}
