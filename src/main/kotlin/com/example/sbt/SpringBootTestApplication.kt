package com.example.sbt

import com.example.config.MySpringBootApplication
import com.example.sbt.annotation.myRunApplication
import jakarta.annotation.PostConstruct
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.JdbcTemplate

@MySpringBootApplication
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