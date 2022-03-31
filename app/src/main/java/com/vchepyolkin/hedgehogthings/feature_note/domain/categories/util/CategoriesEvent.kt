package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util

import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category

sealed class CategoriesEvent {
    data class Order(val categoryOrder: CategoryOrder) : CategoriesEvent()
    data class DeleteCategory(val category: Category) : CategoriesEvent()
    object RestoreCategory : CategoriesEvent()
    object ToggleOrderSection : CategoriesEvent()
}
