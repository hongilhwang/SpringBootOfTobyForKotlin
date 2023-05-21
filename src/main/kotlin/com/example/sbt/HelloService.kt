package com.example.sbt

import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service


fun interface HelloService {
    fun sayHello(name: String): String
}

@Service
class SimpleHelloService : HelloService {
    override fun sayHello(name: String) = "Hello $name"
}

@Service
@Primary
class HelloDecorator(val helloService: HelloService) : HelloService{
    override fun sayHello(name: String): String = "*${helloService.sayHello(name)}*"
}