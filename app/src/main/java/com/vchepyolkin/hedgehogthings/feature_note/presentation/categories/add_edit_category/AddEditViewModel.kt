package com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.add_edit_category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.use_case.CategoryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val categoryUseCases: CategoryUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

}