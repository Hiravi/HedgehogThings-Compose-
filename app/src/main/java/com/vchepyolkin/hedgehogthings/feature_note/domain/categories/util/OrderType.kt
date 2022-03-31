package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
