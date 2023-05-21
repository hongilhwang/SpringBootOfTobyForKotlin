package com.example.sbt

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.DispatcherServlet

@Configuration
@ComponentScan
class HelloApplication {
    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory = TomcatServletWebServerFactory()

    @Bean
    fun dispatcherServlet() = DispatcherServlet()

}

fun main(args: Array<String>) {
    myRunApplication<HelloApplication>(*args)
}
