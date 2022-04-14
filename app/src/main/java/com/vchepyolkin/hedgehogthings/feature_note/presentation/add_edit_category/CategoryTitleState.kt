package com.vchepyolkin.hedgehogthings.feature_note.presentation.add_edit_category

data class CategoryTitleState(
    val text: String = "",
    val hint: String = "",
    var isHintVisible: Boolean = true
)