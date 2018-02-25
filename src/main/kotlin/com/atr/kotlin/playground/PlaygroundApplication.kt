package com.atr.kotlin.playground

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PlaygroundApplication

fun main(args: Array<String>) {
    SpringApplication.run(PlaygroundApplication::class.java, *args)
}
