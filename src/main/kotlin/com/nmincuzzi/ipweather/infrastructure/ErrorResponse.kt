package com.nmincuzzi.ipweather.infrastructure

import org.springframework.http.HttpStatus

class ErrorResponse(
    private val code: String,
    private val message: String,
    private val httpStatus: HttpStatus
)