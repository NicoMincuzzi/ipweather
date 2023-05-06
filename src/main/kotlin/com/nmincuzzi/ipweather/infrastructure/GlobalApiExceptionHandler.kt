package com.nmincuzzi.ipweather.infrastructure

import com.nmincuzzi.ipweather.domain.exception.IpWeatherException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.ServletWebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class GlobalApiExceptionHandler : ResponseEntityExceptionHandler() {

    private val log: Logger = LoggerFactory.getLogger(GlobalApiExceptionHandler::class.java)

    @ExceptionHandler(value = [Exception::class])
    fun handleUncaughtException(e: Exception, request: ServletWebRequest?): ResponseEntity<Any> {
        log.error(e.message + " " + request, e)
        val errorResponseDto = ErrorResponse(
            Exception::class.java.simpleName,
            INTERNAL_SERVER_ERROR.reasonPhrase,
            INTERNAL_SERVER_ERROR
        )
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorResponseDto)
    }

    @ExceptionHandler(value = [IpWeatherException::class])
    fun handleCustomUncaughtBusinessException(e: IpWeatherException, request: ServletWebRequest?): ResponseEntity<Any> {
        log.error(e.message + " " + request, e)
        val errorResponseDto = ErrorResponse(e.code, e.message, e.httpStatus)
        return ResponseEntity.status(e.httpStatus).body(errorResponseDto)
    }
}