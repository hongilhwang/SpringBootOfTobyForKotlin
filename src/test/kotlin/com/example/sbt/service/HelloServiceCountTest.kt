package com.example.sbt.service

import com.example.sbt.HelloBootTest
import com.example.sbt.repository.HelloRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@HelloBootTest
class HelloServiceCountTest constructor(val helloService: HelloService, val helloRepository: HelloRepository) :
    StringSpec({

        "Counting Greetings" {
            (1..10).forEach {
                helloService.sayHello("Toby")
                helloRepository.countOf("Toby") shouldBe it

            }
        }

    })