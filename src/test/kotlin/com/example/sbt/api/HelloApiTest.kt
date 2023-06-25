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

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloApiTest @Autowired constructor(rest: TestRestTemplate) : StringSpec(
    {
        "Hello api" {
            val res = rest.getForEntity("/hello?name={name}", String::class.java, "Spring")
            res.statusCode shouldBe HttpStatus.OK
            res.headers.getFirst(HttpHeaders.CONTENT_TYPE) shouldStartWith MediaType.TEXT_PLAIN_VALUE
            res.body shouldBe "*Hello Spring*"
        }

        "Hello api INTERNAL_SERVER_ERROR" {
            val res = rest.getForEntity("/hello?name=", String::class.java)
            res.statusCode shouldBe HttpStatus.INTERNAL_SERVER_ERROR
        }
    }
)