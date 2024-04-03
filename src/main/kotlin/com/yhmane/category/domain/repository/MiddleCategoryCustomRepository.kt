package com.yhmane.category.domain.repository

import com.yhmane.category.dto.CategoryDto
import com.yhmane.category.domain.entity.MiddleCategoryEntity
import org.springframework.data.domain.Pageable

interface MiddleCategoryCustomRepository {
    fun findAllPageable(dto: CategoryDto, pageable: Pageable): List<MiddleCategoryEntity>
}