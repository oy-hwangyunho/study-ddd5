package com.yhmane.category.domain.repository

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Order
import com.querydsl.core.types.OrderSpecifier
import com.querydsl.jpa.impl.JPAQueryFactory
import com.yhmane.category.dto.CategoryDto
import com.yhmane.category.domain.entity.MiddleCategoryEntity
import com.yhmane.category.domain.entity.QMiddleCategoryEntity
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class MiddleCategoryCustomRepositoryImpl(
    val jpaQueryFactory: JPAQueryFactory
) : MiddleCategoryCustomRepository {
    override fun findAllPageable(dto: CategoryDto, pageable: Pageable): List<MiddleCategoryEntity> {
        val middleCategory = QMiddleCategoryEntity.middleCategoryEntity
        val booleanBuilder = BooleanBuilder()

        dto.useYn?.let {
            booleanBuilder.and(middleCategory.useYn.eq(dto.useYn))
        }

        return jpaQueryFactory
            .select(middleCategory)
            .from(middleCategory)
            .where(middleCategory.largeCategoryEntity.categoryCode.eq(dto.categoryCode))
            .where(booleanBuilder)
            .orderBy(OrderSpecifier(Order.ASC, middleCategory.priority))
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()
    }
}
