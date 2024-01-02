package com.example.sbt

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import java.lang.annotation.ElementType

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [HelloApplication::class])
@TestPropertySource("classpath:/application.properties")
@Transactional
annotation class HelloBootTest()
