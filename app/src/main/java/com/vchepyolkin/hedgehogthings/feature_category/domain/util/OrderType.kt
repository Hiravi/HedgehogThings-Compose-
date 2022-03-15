package com.vchepyolkin.hedgehogthings.feature_category.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
