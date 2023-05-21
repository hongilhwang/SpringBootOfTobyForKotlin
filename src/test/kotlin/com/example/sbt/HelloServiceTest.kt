package com.example.sbt

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HelloServiceTest : StringSpec({
    "simpleHelloService" {
        val helloService = SimpleHelloService()

        val ret = helloService.sayHello("Test")
        ret shouldBe "Hello Test"
    }

    "helloDecorator" {
        val decorator = HelloDecorator { name -> name }
        val ret = decorator.sayHello("Test")

        ret shouldBe "*Test*"
    }
})