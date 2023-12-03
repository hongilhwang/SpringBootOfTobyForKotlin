package com.example.config

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils


class MyOnClassCondition : Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        return metadata.getAnnotationAttributes(ConditionalMyOnClass::class.java.name)
            ?.let { attrs ->
                attrs["value"]
                    ?.toString()
                    ?.let {
                        ClassUtils.isPresent(it, context.classLoader)
                    }
            } ?: false
    }
}