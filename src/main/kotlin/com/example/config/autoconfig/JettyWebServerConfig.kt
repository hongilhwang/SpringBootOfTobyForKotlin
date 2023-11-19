package com.example.config.autoconfig

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.context.annotation.*
import org.springframework.core.type.AnnotatedTypeMetadata


@Configuration
@Conditional(JettyCondition::class)
class JettyWebServerConfig {

    @Bean("jettyWebServerFactory")
    fun servletWebServerFactory(): ServletWebServerFactory = JettyServletWebServerFactory()

}


object JettyCondition : Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {


        return true
    }

}