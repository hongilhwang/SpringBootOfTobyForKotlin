package com.example.sbt

import com.example.config.MySpringBootApplication
import com.example.sbt.annotation.myRunApplication
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment

@MySpringBootApplication
class HelloApplication{}

fun main(args: Array<String>) {
    myRunApplication<HelloApplication>(*args)
}
