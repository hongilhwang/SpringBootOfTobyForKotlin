package com.example.sbt.service

import com.example.sbt.repository.HelloRepository
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service


interface HelloService {
    fun sayHello(name: String): String
    fun countOf(name: String): Int = 0

}

@Service
class SimpleHelloService(val helloRepository: HelloRepository) : HelloService {
    override fun sayHello(name: String) = helloRepository.increaseCount(name).let { "Hello $name" }
    override fun countOf(name: String): Int = helloRepository.countOf(name)
}

@Service
@Primary
class HelloDecorator(val helloService: HelloService) : HelloService {
    override fun sayHello(name: String): String = "*${helloService.sayHello(name)}*"
    override fun countOf(name: String): Int = helloService.countOf(name)
}