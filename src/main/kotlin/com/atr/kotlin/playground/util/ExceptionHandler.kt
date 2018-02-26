package com.atr.kotlin.playground.util

import com.atr.kotlin.playground.todo.TodoValidationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(TodoValidationException::class)
    fun handleDeviceValidationException(ex: TodoValidationException): ResponseEntity<List<String>> =
            ResponseEntity(ex.errors, HttpStatus.BAD_REQUEST)
}