package com.vchepyolkin.hedgehogthings.feature_note.data.data_source


import androidx.room.*
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getCategories() : Flow<List<Category>>

    @Query("SELECT * FROM category WHERE id = :id")
    suspend fun getCategoryById(id: Int) : Category?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)


}