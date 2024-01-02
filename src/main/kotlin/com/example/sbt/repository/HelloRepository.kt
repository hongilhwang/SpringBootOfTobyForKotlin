package com.example.sbt.repository

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository


data class Hello(
    val name: String,
    val count: Int
)

interface HelloRepository {
    fun findHello(name: String): Hello?

    fun increaseCount(name: String)

    fun countOf(name: String): Int {
        val hello = findHello(name)
        return hello?.count ?: 0
    }
}

@Repository
class HelloRepositoryJdbc(val jdbcTemplate: JdbcTemplate) : HelloRepository {

    override fun findHello(name: String): Hello? = try {
        jdbcTemplate.queryForObject(
            "SELECT * FROM hello WHERE name = '${name}'"
        ) { rs, _ -> Hello(rs.getString("name"), rs.getInt("count")) }
    } catch (e: EmptyResultDataAccessException) {
        null
    }


    override fun increaseCount(name: String) {
        val hello = findHello(name)

        hello?.also {
            jdbcTemplate.update("UPDATE hello SET count = ? WHERE name = ?", hello.count + 1, name)
        } ?: jdbcTemplate.update("INSERT INTO hello VALUES(?,?)", name, 1)

    }

}