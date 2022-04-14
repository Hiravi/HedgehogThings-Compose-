package com.vchepyolkin.hedgehogthings.di

import android.app.Application
import androidx.room.Room
import com.vchepyolkin.hedgehogthings.feature_note.data.data_source.CategoryDatabase
import com.vchepyolkin.hedgehogthings.feature_note.data.repository.CategoryRepositoryImpl
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.repository.CategoryRepository
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCategoryDatabase(app: Application) : CategoryDatabase {
        return Room.databaseBuilder(
            app,
            CategoryDatabase::class.java,
            CategoryDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesCategoryRepository(db: CategoryDatabase) : CategoryRepository {
        return CategoryRepositoryImpl(db.categoryDao)
    }

    @Provides
    @Singleton
    fun provideCategoryUseCases(repository: CategoryRepository) : CategoryUseCases {
        return CategoryUseCases(
            getCategories = GetCategories(repository),
            deleteCategory = DeleteCategory(repository),
            addCategory = AddCategory(repository),
            getCategory = GetCategory(repository),
        )
    }
}