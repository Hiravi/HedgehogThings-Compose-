package com.vchepyolkin.hedgehogthings.models

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vchepyolkin.hedgehogthings.ui.theme.Green
import com.vchepyolkin.hedgehogthings.ui.theme.Orange
import com.vchepyolkin.hedgehogthings.ui.theme.Purple
import com.vchepyolkin.hedgehogthings.ui.theme.Red

@Entity
data class Category(
    @PrimaryKey val name: String,
    var id: Int,
    var color: Color
){
    companion object{
        val categoryColors = listOf(Red, Green, Purple, Orange)
    }
}
