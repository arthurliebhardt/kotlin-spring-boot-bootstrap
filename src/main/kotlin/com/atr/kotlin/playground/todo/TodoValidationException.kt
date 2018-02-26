package com.atr.kotlin.playground.todo

class TodoValidationException(message: String, val errors: List<String>) : Exception(message)