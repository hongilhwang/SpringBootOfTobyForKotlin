package com.example.sbt

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class HelloApiTest : StringSpec(
    {
        "Hello api" {
            val rest = TestRestTemplate()

            val res = rest.getForEntity("http://localhost:8080/hello?name={name}", String::class.java, "Spring")
            res.statusCode shouldBe HttpStatus.OK
            res.headers.getFirst(HttpHeaders.CONTENT_TYPE) shouldStartWith MediaType.TEXT_PLAIN_VALUE
            res.body shouldBe "*Hello Spring*"
        }

        "Hello api INTERNAL_SERVER_ERROR" {
            val rest = TestRestTemplate()

            val res = rest.getForEntity("http://localhost:8080/hello?name=", String::class.java)
            res.statusCode shouldBe HttpStatus.INTERNAL_SERVER_ERROR
        }
    }
)