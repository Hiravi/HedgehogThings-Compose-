package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util.CategoryType
import com.vchepyolkin.hedgehogthings.ui.theme.Green
import com.vchepyolkin.hedgehogthings.ui.theme.Orange
import com.vchepyolkin.hedgehogthings.ui.theme.Purple
import com.vchepyolkin.hedgehogthings.ui.theme.Red
import java.lang.Exception

@Entity
data class Category(
    @PrimaryKey val title: String,
    var id: Int,
    var color: Int,
    @TypeConverters(CategoryTypeConverter::class)
    var type: CategoryType,
){
    companion object{
        val categoryColors = listOf(Red, Green, Purple, Orange)
    }
}

class InvalidCategoryException(message: String) : Exception(message)

class CategoryTypeConverter {

    @TypeConverter
    fun fromCategoryType(type: CategoryType) : String {
        return type.toString()
    }

    @TypeConverter
    fun toCategoryType(type: String) : CategoryType {
        return when(type) {
            "Other" -> CategoryType.Other
            "Movies" -> CategoryType.Movies
            "Food" -> CategoryType.Food
            "Holidays" -> CategoryType.Holidays
            "ShoppingList" -> CategoryType.ShoppingList
            else -> {
                CategoryType.Other
            }
        }
    }
}