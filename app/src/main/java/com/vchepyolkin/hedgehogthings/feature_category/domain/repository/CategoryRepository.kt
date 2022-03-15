package com.vchepyolkin.hedgehogthings.feature_category.domain.repository

import com.vchepyolkin.hedgehogthings.feature_category.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getCategories() : Flow<List<Category>>

    suspend fun getCategoryById(id: Int) : Category?

    suspend fun insertCategory(category: Category)

    suspend fun deleteCategory(category: Category)
}