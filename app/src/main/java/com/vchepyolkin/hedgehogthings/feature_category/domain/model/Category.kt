package com.vchepyolkin.hedgehogthings.feature_category.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vchepyolkin.hedgehogthings.ui.theme.Green
import com.vchepyolkin.hedgehogthings.ui.theme.Orange
import com.vchepyolkin.hedgehogthings.ui.theme.Purple
import com.vchepyolkin.hedgehogthings.ui.theme.Red
import java.lang.Exception

@Entity
data class Category(
    @PrimaryKey val title: String,
    var id: Int,
    var color: Int
){
    companion object{
        val categoryColors = listOf(Red, Green, Purple, Orange)
    }
}

class InvalidCategoryException(message: String) : Exception(message) {

}