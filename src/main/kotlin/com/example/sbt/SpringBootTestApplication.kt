package com.example.sbt

import com.example.sbt.annotation.MySpringBootAnnotation
import com.example.sbt.annotation.myRunApplication

@MySpringBootAnnotation
class HelloApplication

fun main(args: Array<String>) {
    myRunApplication<HelloApplication>(*args)
}
