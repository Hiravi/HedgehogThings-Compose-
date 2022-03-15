package com.vchepyolkin.hedgehogthings.feature_category.domain.util

sealed class CategoryOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : CategoryOrder(orderType)
    class Color(orderType: OrderType) : CategoryOrder(orderType)

    fun copy(orderType: OrderType) : CategoryOrder {
        return when(this) {
            is Title -> Title(orderType)
            is Color -> Color(orderType)
        }
    }
}