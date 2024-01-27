package com.example.sbt.service

import com.example.sbt.repository.Hello
import com.example.sbt.repository.HelloRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HelloServiceTest : StringSpec({
    "simpleHelloService" {
        val helloService = SimpleHelloService(object : HelloRepository {
            override fun findHello(name: String): Hello? = null

            override fun increaseCount(name: String) {

            }

        })

        val ret = helloService.sayHello("Test")
        ret shouldBe "Hello Test"
    }

    "helloDecorator" {
        val decorator = HelloDecorator(object : HelloService {
            override fun sayHello(name: String): String {
                return name
            }

        })
        val ret = decorator.sayHello("Test")

        ret shouldBe "*Test*"
    }
})