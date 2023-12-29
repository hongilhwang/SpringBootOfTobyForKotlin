package com.example.sbt.config

import com.example.sbt.HelloApplication
import io.kotest.core.spec.style.StringSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.sql.DataSource

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [HelloApplication::class])
@TestPropertySource("classpath:/application.properties")
class DataSourceTest constructor(dataSource: DataSource) : StringSpec({

    "connect" {
        val connection = dataSource.connection

        connection.close()
    }
})