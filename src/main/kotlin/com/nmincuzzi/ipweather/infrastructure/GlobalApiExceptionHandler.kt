package com.nmincuzzi.ipweather.infrastructure

import com.nmincuzzi.ipweather.domain.exception.IpWeatherException
import lombok.extern.slf4j.Slf4j
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
@Slf4j
class GlobalApiExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [Exception::class])
    fun handleUncaughtException(ex: Exception?, request: ServletWebRequest?): ResponseEntity<Any> {
        //log(ex, request)
        val errorResponseDto = ErrorResponse(
            Exception::class.java.simpleName,
            INTERNAL_SERVER_ERROR.reasonPhrase,
            INTERNAL_SERVER_ERROR
        )
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorResponseDto)
    }

    @ExceptionHandler(value = [IpWeatherException::class])
    fun handleCustomUncaughtBusinessException(
        ex: IpWeatherException,
        request: ServletWebRequest?
    ): ResponseEntity<Any> {
        //log(ex, request)
        val errorResponseDto = ErrorResponse(ex.code, ex.message, ex.httpStatus)
        return ResponseEntity.status(ex.httpStatus).body(errorResponseDto)
    }
}