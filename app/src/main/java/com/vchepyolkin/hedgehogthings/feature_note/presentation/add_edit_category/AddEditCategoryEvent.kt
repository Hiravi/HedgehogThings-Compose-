package com.vchepyolkin.hedgehogthings.feature_note.presentation.add_edit_category

import androidx.compose.ui.focus.FocusState

sealed class AddEditCategoryEvent {
    data class EnteredTitle(val value: String) : AddEditCategoryEvent()
    data class ChangeTitleFocus(val focus: FocusState) : AddEditCategoryEvent()
    data class ChangeColor(val color: Int) : AddEditCategoryEvent()
    object SaveCategory : AddEditCategoryEvent()
}
