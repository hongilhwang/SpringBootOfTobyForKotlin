package com.example.sbt.config

import io.kotest.core.spec.style.StringSpec
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import javax.sql.DataSource

@JdbcTest
class DataSourceTest constructor(dataSource: DataSource) : StringSpec({

    "connect" {
        val connection = dataSource.connection

        connection.close()
    }
})