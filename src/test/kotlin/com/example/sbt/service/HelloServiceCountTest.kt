package com.example.sbt.service

import com.example.sbt.repository.HelloRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class HelloServiceCountTest constructor(val helloService: HelloService, val helloRepository: HelloRepository) :
    StringSpec({

        "Counting Greetings" {
            (1..10).forEach {
                helloService.sayHello("Toby")
                helloRepository.countOf("Toby") shouldBe it

            }
        }

    })