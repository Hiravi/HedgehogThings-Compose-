package com.vchepyolkin.hedgehogthings.feature_note.presentation.categories
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.model.Category
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.use_case.CategoryUseCases
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util.CategoriesEvent
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util.CategoryOrder
import com.vchepyolkin.hedgehogthings.feature_note.domain.categories.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val categoryUseCases: CategoryUseCases
) : ViewModel() {

    private val _state = mutableStateOf(CategoriesState())
    val state: State<CategoriesState> = _state

    private var recentlyDeletedCategory: Category? = null

    private var getCategoriesJob: Job? = null

    init {
        getCategories(CategoryOrder.Title(OrderType.Descending))
    }

    fun  onEvent(event: CategoriesEvent) {
        when(event) {
            is CategoriesEvent.Order -> {
                if (state.value.categoryOrder::class == event.categoryOrder::class &&
                        state.value.categoryOrder.orderType == event.categoryOrder.orderType
                ) {
                    return
                }
                getCategories(event.categoryOrder)
            }
            is CategoriesEvent.DeleteCategory -> {
                viewModelScope.launch {
                    recentlyDeletedCategory = event.category
                    categoryUseCases.deleteCategory(event.category)
                }
            }
            is CategoriesEvent.RestoreCategory -> {
                viewModelScope.launch {
                    categoryUseCases.addCategory(recentlyDeletedCategory ?: return@launch)
                    recentlyDeletedCategory = null
                }
            }
            is CategoriesEvent.ToggleOrderSection -> {
                _state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible,
                )
            }
        }
    }

    private fun getCategories(categoryOrder: CategoryOrder) {
        getCategoriesJob?.cancel()

        getCategoriesJob = categoryUseCases.getCategories(categoryOrder)
            .onEach { categories ->
                _state.value = state.value.copy(
                    categories = categories,
                    categoryOrder = categoryOrder,
                )
            }
            .launchIn(viewModelScope)
    }
}