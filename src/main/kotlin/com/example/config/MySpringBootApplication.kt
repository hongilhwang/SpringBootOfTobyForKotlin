package com.example.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Configuration
@ComponentScan
@SpringBootConfiguration
@EnableMyAutoConfiguration
annotation class MySpringBootApplication()
