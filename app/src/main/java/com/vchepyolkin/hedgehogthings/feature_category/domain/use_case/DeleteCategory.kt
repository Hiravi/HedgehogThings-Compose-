package com.vchepyolkin.hedgehogthings.feature_category.domain.use_case

import com.vchepyolkin.hedgehogthings.feature_category.domain.repository.CategoryRepository
import com.vchepyolkin.hedgehogthings.feature_category.domain.model.Category

class DeleteCategory(
    private val repository: CategoryRepository
) {

    suspend operator fun invoke(category: Category) {
        repository.deleteCategory(category)
    }
}