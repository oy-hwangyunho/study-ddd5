package com.yhmane.category.domain.exception

class CategoryCodeNotFoundException(
    private val categoryCode: String
) : RuntimeException() {

    override val message: String by lazy {
        "category code를 찾을 수 없습니다, categoryCode: $categoryCode"
    }
}
