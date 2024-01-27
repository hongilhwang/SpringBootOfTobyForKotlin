package com.example.sbt.api

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension


@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
class HelloApiTest : StringSpec(
    {
        "Hello api" {
            val restTemplate = TestRestTemplate()
            val res =
                restTemplate.getForEntity("http://localhost:9090/app/hello?name={name}", String::class.java, "Spring")
            res.statusCode shouldBe HttpStatus.OK
            res.headers.getFirst(HttpHeaders.CONTENT_TYPE) shouldStartWith MediaType.TEXT_PLAIN_VALUE
            res.body shouldBe "*Hello Spring*"
        }

        "Hello api INTERNAL_SERVER_ERROR" {
            val restTemplate = TestRestTemplate()
            val res = restTemplate.getForEntity("http://localhost:9090/app/hello?name=", String::class.java)
            res.statusCode shouldBe HttpStatus.INTERNAL_SERVER_ERROR
        }
    }
)

