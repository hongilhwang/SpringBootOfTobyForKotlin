package com.example.sbt.controller

import com.example.sbt.service.HelloService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HelloControllerTest : StringSpec({
    "helloController" {
        val helloController = HelloController(object : HelloService {
            override fun sayHello(name: String): String = name
        })
        val ret = helloController.hello("Test")
        ret shouldBe "Test"
    }

    "failsHelloController" {
        val helloController = HelloController(object : HelloService {
            override fun sayHello(name: String): String = name
        })

        shouldThrow<IllegalArgumentException> {
            helloController.hello(null)
        }
        shouldThrow<IllegalArgumentException> {
            helloController.hello("")
        }
        shouldThrow<IllegalArgumentException> {
            helloController.hello("   ")
        }
    }
})