package com.nmincuzzi.ipweather.domain.exception

import org.springframework.http.HttpStatus
import java.lang.String.format


class IpWeatherException : RuntimeException {
    val code: String
    override val message: String
    val httpStatus: HttpStatus

    constructor(reason: IpWeatherExceptionReason) {
        this.code = reason.getCode()
        message = reason.getMessage()
        httpStatus = reason.getHttpStatus()
    }

    constructor(reason: IpWeatherExceptionReason, overridingHttpStatus: HttpStatus) {
        this.code = reason.getCode()
        message = reason.getMessage()
        httpStatus = overridingHttpStatus
    }

    constructor(reason: IpWeatherExceptionReason, vararg parameters: Any?) {
        message = if (parameters != null) {
            format(reason.getMessage(), parameters)
        } else {
            reason.getMessage()
        }
        this.code = reason.getCode()
        httpStatus = reason.getHttpStatus()
    }

    override fun getLocalizedMessage(): String {
        return message
    }

    override fun toString(): String {
        return format("IpWeatherException(code=%s, message=%s, httpStatus=%s)", this.code, message, httpStatus.value())
    }
}