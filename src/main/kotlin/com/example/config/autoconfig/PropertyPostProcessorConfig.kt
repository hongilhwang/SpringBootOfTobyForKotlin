package com.example.config.autoconfig

import com.example.config.MyAutoConfiguration
import com.example.config.MyConfigurationProperties
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.core.annotation.AnnotationUtils
import org.springframework.core.env.Environment


@MyAutoConfiguration
class PropertyPostProcessorConfig {
    @Bean
    fun propertyPostProcessorConfig(env: Environment) = object : BeanPostProcessor {

        override fun postProcessBeforeInitialization(bean: Any, beanName: String): Any {
            val annotation = AnnotationUtils.findAnnotation(bean.javaClass, MyConfigurationProperties::class.java)



            return annotation?.let {
                val attrs = AnnotationUtils.getAnnotationAttributes(it)
                val prefix = attrs["prefix"].toString()
                Binder.get(env).bindOrCreate(prefix, bean.javaClass)
            } ?: bean
        }
    }
}