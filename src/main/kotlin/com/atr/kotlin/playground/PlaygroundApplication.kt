package com.atr.kotlin.playground

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class PlaygroundApplication

fun main(args: Array<String>) {
    SpringApplication.run(PlaygroundApplication::class.java, *args)
}
