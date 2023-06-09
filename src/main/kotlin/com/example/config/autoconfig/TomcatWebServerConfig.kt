package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@MyAutoConfiguration
class TomcatWebServerConfig {

    @Bean
    fun servletWebServerFactory(): ServletWebServerFactory = TomcatServletWebServerFactory()

}