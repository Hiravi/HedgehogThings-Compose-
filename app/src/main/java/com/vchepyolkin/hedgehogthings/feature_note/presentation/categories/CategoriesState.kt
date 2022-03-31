package com.vchepyolkin.hedgehogthings.feature_note.presentation.categories

import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util.CategoryOrder
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util.OrderType

data class CategoriesState(
    val categories: List<Category> = emptyList(),
    val categoryOrder: CategoryOrder = CategoryOrder.Title(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
)
