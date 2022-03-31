package com.vchepyolkin.hedgehogthings.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.CategoryTypeConverter

@Database(
    entities = [Category::class],
    version = 1
)
@TypeConverters(CategoryTypeConverter::class)
abstract class CategoryDatabase : RoomDatabase() {
    abstract val categoryDao: CategoryDao

    companion object {
        const val DATABASE_NAME = "categories_db"
    }
}