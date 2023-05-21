package com.example.sbt

import org.springframework.stereotype.Component


fun interface HelloService {
    fun sayHello(name: String): String
}

@Component
class SimpleHelloService : HelloService {
    override fun sayHello(name: String) = "Hello $name"
}