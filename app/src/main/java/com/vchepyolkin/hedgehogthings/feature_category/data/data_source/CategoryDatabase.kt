package com.vchepyolkin.hedgehogthings.feature_category.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vchepyolkin.hedgehogthings.feature_category.domain.model.Category

@Database(
    entities = [Category::class],
    version = 1
)

abstract class CategoryDatabase : RoomDatabase() {
    abstract val categoryDao: CategoryDao

    companion object {
        const val DATABASE_NAME = "categories_db"
    }
}