package com.yhmane.category.domain.type

enum class UseYn {
    Y,
    N,
    ;

    companion object {
        fun getUseYn(type: String) = try {
            valueOf(type.uppercase())
        } catch (e: IllegalArgumentException) {
            null
        } catch (e: NullPointerException) {
            null
        }
    }
}