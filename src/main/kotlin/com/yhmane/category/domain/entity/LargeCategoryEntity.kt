package com.yhmane.category.domain.entity

import com.yhmane.category.domain.type.UseYn
import javax.persistence.*

@Entity
@Table(name = "large_category")
class LargeCategoryEntity : BaseTimeEntity() {


    @Id
    @Column(name = "large_category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "d_cat_cd")
    var categoryCode: String? = null

    @Column(name = "title")
    var categoryName: String? = null

    @Column(name = "priority")
    var priority: Int? = null

    @Column(name = "use_yn")
    @Enumerated(EnumType.STRING)
    var useYn: UseYn? = UseYn.Y

    @OneToMany(mappedBy = "largeCategoryEntity", fetch = FetchType.LAZY)
    val middleCategories: MutableList<MiddleCategoryEntity> = mutableListOf()
}
