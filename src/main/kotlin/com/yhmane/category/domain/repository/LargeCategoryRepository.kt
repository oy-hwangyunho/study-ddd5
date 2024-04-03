package com.yhmane.category.domain.repository

import com.yhmane.category.domain.entity.LargeCategoryEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface LargeCategoryRepository : CrudRepository<LargeCategoryEntity, Long> {

    fun findByCategoryCode(categoryCode: String): Optional<LargeCategoryEntity>

    @Query("SELECT distinct l FROM LargeCategoryEntity l join fetch l.middleCategories")
    fun findAllWithFetchJoin(): List<LargeCategoryEntity>

    @Query(value = "SELECT max(priority) FROM LargeCategoryEntity")
    fun maxPriority(): Int
}
