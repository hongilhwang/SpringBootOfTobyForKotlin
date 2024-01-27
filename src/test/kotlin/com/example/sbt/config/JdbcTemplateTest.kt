package com.example.sbt.config

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.jdbc.core.JdbcTemplate

@JdbcTest
class JdbcTemplateTest constructor(val jdbcTemplate: JdbcTemplate) : StringSpec({

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

    "insert and query" {
        jdbcTemplate.update("INSERT INTO hello VALUES (?, ? )", "Camveloper", 3)
        jdbcTemplate.update("INSERT INTO hello VALUES (?, ? )", "Spring", 1)

        val cnt = jdbcTemplate.queryForObject("SELECT COUNT(*) AS CNT FROM hello", Long::class.java)

        cnt shouldBe 2

    }

    "insert and query2" {
        jdbcTemplate.update("INSERT INTO hello VALUES (?, ? )", "Camveloper", 3)
        jdbcTemplate.update("INSERT INTO hello VALUES (?, ? )", "Spring", 1)

        val cnt = jdbcTemplate.queryForObject("SELECT COUNT(*) AS CNT FROM hello", Long::class.java)

        cnt shouldBe 2

    }


})