package com.yhmane.category.config

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MySQLContainer

private const val IMAGE_NAME = "mysql:8.0"
private const val DATABASE_NAME = "yh"

@TestConfiguration
class MySQLTestConfig {

    class MySqlContainer : MySQLContainer<MySqlContainer>(IMAGE_NAME)

    private val mySqlContainer: MySQLContainer<*> = MySQLContainer<MySqlContainer>(IMAGE_NAME).apply {
        withUsername("root")
        withPassword("")
        withDatabaseName(DATABASE_NAME)
        withInitScript("data.sql")
        withUrlParam("useUnicode", "true")
        withUrlParam("characterEncoding", "utf-8")
        withUrlParam("connectionCollation", "utf8_bin")
        withUrlParam("characterSetResults", "utf8")
        withUrlParam("serverTimezone", "Asia/Seoul")
        withUrlParam("zeroDateTimeBehavior", "convertToNull")
        withReuse(true)

        start()
    }

    @Bean
    fun dataSource() = DataSourceBuilder.create()
        .url(mySqlContainer.jdbcUrl)
        .driverClassName(mySqlContainer.driverClassName)
        .username(mySqlContainer.username)
        .build()
}
