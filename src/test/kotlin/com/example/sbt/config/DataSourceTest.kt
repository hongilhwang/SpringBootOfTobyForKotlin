package com.example.sbt.config

import com.example.sbt.HelloApplication
import com.example.sbt.HelloBootTest
import io.kotest.core.spec.style.StringSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.sql.DataSource

@HelloBootTest
class DataSourceTest constructor(dataSource: DataSource) : StringSpec({

    "connect" {
        val connection = dataSource.connection

        connection.close()
    }
})