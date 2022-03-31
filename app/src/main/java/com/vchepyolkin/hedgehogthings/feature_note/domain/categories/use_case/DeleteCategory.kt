package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.use_case

import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.repository.CategoryRepository
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category

class DeleteCategory(
    private val repository: CategoryRepository
) {

    suspend operator fun invoke(category: Category) {
        repository.deleteCategory(category)
    }
}