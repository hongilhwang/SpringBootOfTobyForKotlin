package com.example.config

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata
import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

class MyConfigurationPropertiesImportSelector : DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val attr = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties::class.java.name)

        return attr?.let {
            val value: Class<Any> = attr.getFirst("value") as Class<Any>

            value.let {
                val name = value.name
                arrayOf(name)
            } ?: arrayOf()

        } ?: arrayOf()
    }

}
