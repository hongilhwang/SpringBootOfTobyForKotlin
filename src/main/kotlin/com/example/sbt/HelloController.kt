package com.example.sbt

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(private val helloService: HelloService) {

    @GetMapping("/hello")
    fun hello(name: String?): String {
        if (name.isNullOrBlank()) throw IllegalArgumentException()
        return helloService.sayHello(name)
    }

}