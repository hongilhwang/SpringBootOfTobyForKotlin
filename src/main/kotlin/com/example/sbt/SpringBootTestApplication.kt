package com.example.sbt

import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootApplication
class HelloApplication(val jdbcTemplate: JdbcTemplate) {

    @PostConstruct
    fun init() {
        jdbcTemplate.execute(
            """
            CREATE TABLE IF NOT EXISTS hello(
                name VARCHAR(50) PRIMARY KEY, 
                count INT 
            )
        """.trimIndent()
        )
    }

}

fun main(args: Array<String>) {
    runApplication<HelloApplication>(*args)
}