package com.yhmane.category.domain.repository

import com.yhmane.category.config.MySQLTestConfig
import com.yhmane.category.config.QueryFactoryTestConfig
import com.yhmane.category.domain.exception.CategoryCodeNotFoundException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@Import(MySQLTestConfig::class, QueryFactoryTestConfig::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LargeCategoryRepositoryTest {

    @Autowired
    private lateinit var largeCategoryRepository: LargeCategoryRepository

    @Test
    fun findByCategoryCodeTest() {
        // given
        val categoryCode = "001"

        // when
        val largeCategory = largeCategoryRepository.findByCategoryCode(categoryCode)
            .orElseThrow { throw CategoryCodeNotFoundException(categoryCode) }

        assertAll(
            { assertThat(largeCategory.categoryCode).isEqualTo("001") },
            { assertThat(largeCategory.categoryName).isEqualTo("상의") },
        )
    }

    @Test
    fun findAllWithFetchJoinTest() {
        // given
        // test > data.sql 초기 데이터 (001, 002) 2개

        // when
        val findAllWithFetchJoin = largeCategoryRepository.findAllWithFetchJoin()

        // then
        assertThat(findAllWithFetchJoin.size).isEqualTo(2)
    }

    @Test
    fun maxPriorityTest() {
        // given
        // test > data.sql 초기 데이터 max = 2

        // when
        val maxPriority = largeCategoryRepository.maxPriority()

        // then
        assertThat(maxPriority).isEqualTo(2)
    }
}
