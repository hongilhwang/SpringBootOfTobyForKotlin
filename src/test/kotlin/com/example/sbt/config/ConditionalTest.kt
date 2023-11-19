package com.example.sbt.config

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.core.type.AnnotatedTypeMetadata

import org.springframework.beans.factory.getBeanNamesForType


class ConditionalTest : StringSpec({
    "conditional 만들고 테스트" {

        // true
        val contextRunner = ApplicationContextRunner();
        contextRunner.withUserConfiguration(Config1::class.java)
            .run { context ->
                run {
                    // Assertions.assertThat(context).hasSingleBean(MyBean::class.java)
                    context.getBeanNamesForType<MyBean>().size shouldBe 1
                    // Assertions.assertThat(context).hasSingleBean(Config1::class.java)
                    context.getBeanNamesForType<Config1>().size shouldBe 1
                }
            }

        //false
        val contextRunner2 = ApplicationContextRunner();
        contextRunner2.withUserConfiguration(Config2::class.java)
            .run { context ->
                run {
                    // Assertions.assertThat(context).hasSingleBean(MyBean::class.java)
                    context.getBeanNamesForType<MyBean>().size shouldBe 0
                    // Assertions.assertThat(context).hasSingleBean(Config1::class.java)
                    context.getBeanNamesForType<Config2>().size shouldBe 0
                }
            }
    }


}) {

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
    @Conditional(BooleanCondition::class)
    annotation class BooleanConditional(val value: Boolean)

    @Configuration
    @BooleanConditional(value = true)
    class Config1 {

        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }


    @Configuration
    @BooleanConditional(false)
    class Config2 {

        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }


    class MyBean()
    private object BooleanCondition : Condition {
        override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            val attr = metadata.getAnnotationAttributes(BooleanConditional::class.java.name)

            return attr?.get("value")?.let { it as Boolean } ?: false
        }
    }
}