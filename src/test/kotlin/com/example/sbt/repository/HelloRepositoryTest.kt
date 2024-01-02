package com.example.sbt.repository

import com.example.sbt.HelloBootTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.springframework.jdbc.core.JdbcTemplate

@HelloBootTest
class HelloRepositoryTest constructor(
    val jdbcTemplate: JdbcTemplate,
    val helloRepository: HelloRepository
) : StringSpec({

    beforeTest {
        jdbcTemplate.execute(
            """
            CREATE TABLE IF NOT EXISTS hello(
                name VARCHAR(50) PRIMARY KEY, 
                count INT 
            )
        """.trimIndent()
        )
    }

    "Failed to find in hello" {
        helloRepository.findHello("Toby") shouldBe null
    }

    "Increase count" {
        helloRepository.countOf("Toby") shouldBe 0
        
        helloRepository.increaseCount("Toby")
        helloRepository.countOf("Toby") shouldBe 1

        helloRepository.increaseCount("Toby")
        helloRepository.countOf("Toby") shouldBe 2
    }
})