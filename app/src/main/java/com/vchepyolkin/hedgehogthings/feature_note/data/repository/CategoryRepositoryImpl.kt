package com.vchepyolkin.hedgehogthings.feature_note.data.repository

import com.vchepyolkin.hedgehogthings.feature_note.data.data_source.CategoryDao
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.repository.CategoryRepository
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(
    private val dao: CategoryDao
) : CategoryRepository {
    override fun getCategories(): Flow<List<Category>> {
        return dao.getCategories()
    }

    override suspend fun getCategoryById(id: Int): Category? {
        return dao.getCategoryById(id)
    }

    override suspend fun insertCategory(category: Category) {
        dao.insertCategory(category)
    }

    override suspend fun deleteCategory(category: Category) {
        dao.deleteCategory(category)
    }

}