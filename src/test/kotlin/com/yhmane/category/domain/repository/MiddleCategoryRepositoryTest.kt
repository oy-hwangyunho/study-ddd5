package com.yhmane.category.domain.repository

import com.yhmane.category.dto.CategoryDto
import com.yhmane.category.config.MySQLTestConfig
import com.yhmane.category.config.QueryFactoryTestConfig
import com.yhmane.category.domain.exception.CategoryCodeNotFoundException
import com.yhmane.category.domain.type.UseYn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

@Import(MySQLTestConfig::class, QueryFactoryTestConfig::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MiddleCategoryRepositoryTest {

    @Autowired
    private lateinit var middleCategoryRepository: MiddleCategoryRepository

    @Autowired
    private lateinit var largeCategoryRepository: LargeCategoryRepository


    @Test
    fun findByCategoryCodeTest() {
        // given
        val categoryCode = "002020"

        // when
        val middleCategory = middleCategoryRepository.findByCategoryCode(categoryCode)
            .orElseThrow { throw CategoryCodeNotFoundException(categoryCode) }

        assertAll(
            { assertThat(middleCategory.categoryCode).isEqualTo("002020") },
            { assertThat(middleCategory.categoryName).isEqualTo("카디건") },
        )
    }

    @Test
    fun pagingAndSortTest() {
        // given
        val largeCategoryCode = "002"
        val largeCateogry = largeCategoryRepository.findByCategoryCode(largeCategoryCode)
            .orElseThrow { throw CategoryCodeNotFoundException(largeCategoryCode)}
        val sort = Sort.by("priority").ascending()
        val pageable = PageRequest.of(1,  10, sort)

        // when
        val pageingCategories = middleCategoryRepository.findByLargeCategoryEntity(largeCateogry, pageable)

        // then
        val content = pageingCategories.content
        assertAll(
            { assertThat(pageingCategories.totalElements).isEqualTo(21) },
            { assertThat(pageingCategories.totalPages).isEqualTo(3) },
            { assertThat(content.first().priority).isEqualTo(11) },
            { assertThat(content.first().categoryCode).isEqualTo("002008") },
            { assertThat(content.last().priority).isEqualTo(20) },
            { assertThat(content.last().categoryCode).isEqualTo("002006") },
        )
    }

    @Test
    fun queryDslTest() {
        // given
        val categoryDto = CategoryDto("002", UseYn.Y)
        val sort = Sort.by("priority").ascending()
        val pageable = PageRequest.of(1,  10, sort)

        // when
        val categories = middleCategoryRepository.findAllPageable(categoryDto, pageable)

        // then
        assertAll(
            { assertThat(categories.first().priority).isEqualTo(11) },
            { assertThat(categories.first().categoryCode).isEqualTo("002008") },
            { assertThat(categories.last().priority).isEqualTo(20) },
            { assertThat(categories.last().categoryCode).isEqualTo("002006") },
        )
    }
}