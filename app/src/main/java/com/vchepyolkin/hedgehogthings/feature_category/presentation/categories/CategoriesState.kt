package com.vchepyolkin.hedgehogthings.feature_category.presentation.categories

import com.vchepyolkin.hedgehogthings.feature_category.domain.model.Category
import com.vchepyolkin.hedgehogthings.feature_category.domain.util.CategoryOrder
import com.vchepyolkin.hedgehogthings.feature_category.domain.util.OrderType

data class CategoriesState(
    val categories: List<Category> = emptyList(),
    val categoryOrder: CategoryOrder = CategoryOrder.Title(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false,
)
