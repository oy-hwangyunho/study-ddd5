package com.yhmane.category

import com.yhmane.category.config.MySQLTestConfig
import com.yhmane.category.config.QueryFactoryTestConfig
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
	classes = [MySQLTestConfig::class, QueryFactoryTestConfig::class]
)
class CategoryApplicationTests {

	@Test
	fun contextLoads() {
	}
}
