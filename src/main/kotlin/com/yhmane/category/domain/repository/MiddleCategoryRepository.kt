package com.yhmane.category.domain.repository

import com.yhmane.category.domain.entity.LargeCategoryEntity
import com.yhmane.category.domain.entity.MiddleCategoryEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface MiddleCategoryRepository : JpaRepository<MiddleCategoryEntity, Long>, MiddleCategoryCustomRepository {

    fun findByCategoryCode(categoryCode: String): Optional<MiddleCategoryEntity>

    fun findByLargeCategoryEntity(largeCategoryEntity: LargeCategoryEntity, pageable: Pageable): Page<MiddleCategoryEntity>
}
