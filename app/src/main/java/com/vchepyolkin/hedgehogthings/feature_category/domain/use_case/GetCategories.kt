package com.vchepyolkin.hedgehogthings.feature_category.domain.use_case

import com.vchepyolkin.hedgehogthings.feature_category.domain.repository.CategoryRepository
import com.vchepyolkin.hedgehogthings.feature_category.domain.util.CategoryOrder
import com.vchepyolkin.hedgehogthings.feature_category.domain.util.OrderType
import com.vchepyolkin.hedgehogthings.feature_category.domain.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCategories(
    private val repository: CategoryRepository
) {

    operator fun invoke(
        categoryOrder: CategoryOrder = CategoryOrder.Title(OrderType.Descending)
    ) : Flow<List<Category>> {
        return repository.getCategories().map { categories ->
            when(categoryOrder.orderType) {
                is OrderType.Descending -> {
                    when(categoryOrder) {
                        is CategoryOrder.Title -> categories.sortedByDescending { it.title.lowercase() }
                        is CategoryOrder.Color -> categories.sortedByDescending { it.color }
                    }
                }
                is OrderType.Ascending -> {
                    when(categoryOrder) {
                        is CategoryOrder.Title -> categories.sortedBy { it.title.lowercase() }
                        is CategoryOrder.Color -> categories.sortedBy { it.color }
                    }
                }
            }
        }
    }

}