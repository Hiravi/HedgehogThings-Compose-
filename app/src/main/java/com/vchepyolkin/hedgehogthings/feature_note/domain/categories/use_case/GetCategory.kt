package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.use_case

import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.repository.CategoryRepository

class GetCategory(
    private val repository: CategoryRepository
) {

    suspend operator fun invoke(id: Int) : Category? {
        return repository.getCategoryById(id)
    }
}