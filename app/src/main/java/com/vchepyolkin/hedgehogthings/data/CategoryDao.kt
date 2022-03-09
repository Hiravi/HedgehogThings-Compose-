package com.vchepyolkin.hedgehogthings.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vchepyolkin.hedgehogthings.models.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getCategory() : Flow<List<Category>>

    @Query("SELECT * FROM category WHERE id = :id")
    suspend fun getCategoryById(id: Int) : Category?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)


}