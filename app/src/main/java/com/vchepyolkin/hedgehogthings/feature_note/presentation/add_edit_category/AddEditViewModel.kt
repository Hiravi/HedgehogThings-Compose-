package com.vchepyolkin.hedgehogthings.feature_note.presentation.add_edit_category

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.InvalidCategoryException
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.use_case.CategoryUseCases
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val categoryUseCases: CategoryUseCases,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _categoryTitle = mutableStateOf(
        CategoryTitleState(
        hint = "Enter title..."
    )
    )
    val categoryTitle: State<CategoryTitleState> = _categoryTitle

    private val _categoryColor = mutableStateOf(Category.categoryColors.random().toArgb())
    val categoryColor: State<Int> = _categoryColor

    private val _categoryType = mutableStateOf(CategoryType.Other)
    val categoryType: State<CategoryType> = _categoryType

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentCategoryId: Int? = null

    init {
        savedStateHandle.get<Int>("categoryId")?.let { categoryId ->
            if (categoryId != -1) {
                viewModelScope.launch {
                    categoryUseCases.getCategory(categoryId)?.also { category ->
                        currentCategoryId = category.id
                        _categoryTitle.value = categoryTitle.value.copy(
                            text = category.title,
                            isHintVisible = false,
                        )
                        _categoryColor.value = category.color
                    }
                }
            }

        }
    }

    fun onEvent(event: AddEditCategoryEvent) {
        when(event) {
            is AddEditCategoryEvent.EnteredTitle -> {
                _categoryTitle.value = categoryTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditCategoryEvent.ChangeTitleFocus -> {
                _categoryTitle.value = categoryTitle.value.copy(
                    isHintVisible = !event.focus.isFocused &&
                            categoryTitle.value.text.isBlank()
                )
            }
            is AddEditCategoryEvent.ChangeColor -> {
                _categoryColor.value = event.color
            }
            is AddEditCategoryEvent.SaveCategory -> {
                viewModelScope.launch {
                    try {
                        categoryUseCases.addCategory(
                            Category(
                                title = categoryTitle.value.text,
                                color = categoryColor.value,
                                type = categoryType.value,
                                id = currentCategoryId
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveCategory)
                    } catch (e: InvalidCategoryException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save note"
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String) : UiEvent()
        object SaveCategory: UiEvent()
    }

}