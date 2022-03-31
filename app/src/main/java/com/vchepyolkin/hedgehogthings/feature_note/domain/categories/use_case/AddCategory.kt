package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.use_case

import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.InvalidCategoryException
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.repository.CategoryRepository

class AddCategory(
    private val repository: CategoryRepository
) {

    @Throws(InvalidCategoryException::class)
    suspend operator fun invoke(category: Category) {
        if (category.title.isBlank()) {
            throw InvalidCategoryException("The title of the category can't be empty!")
        }

        repository.insertCategory(category)
    }
}