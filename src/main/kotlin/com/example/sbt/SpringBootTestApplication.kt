package com.example.sbt

import com.example.config.MySpringBootApplication
import com.example.sbt.annotation.myRunApplication

@MySpringBootApplication
class HelloApplication

fun main(args: Array<String>) {
    myRunApplication<HelloApplication>(*args)
}
