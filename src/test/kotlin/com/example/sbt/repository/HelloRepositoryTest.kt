package com.example.sbt.repository

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloRepositoryTest constructor(
    val jdbcTemplate: JdbcTemplate,
    val helloRepository: HelloRepository
) : StringSpec({

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