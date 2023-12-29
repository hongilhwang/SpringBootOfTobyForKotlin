package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment


@MyAutoConfiguration
class ServerPropertiesConfig {
    @Bean
    fun serverProperties(env: Environment): ServerProperties =
        Binder.get(env).bind<ServerProperties>("", ServerProperties::class.java).get()
}