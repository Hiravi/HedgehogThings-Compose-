package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.repository

import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getCategories() : Flow<List<Category>>

    suspend fun getCategoryById(id: Int) : Category?

    suspend fun insertCategory(category: Category)

    suspend fun deleteCategory(category: Category)
}