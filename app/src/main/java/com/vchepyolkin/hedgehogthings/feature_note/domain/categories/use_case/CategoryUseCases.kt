package com.vchepyolkin.hedgehogthings.feature_note.domain.categories.use_case

data class CategoryUseCases(
    val getCategories: GetCategories,
    val deleteCategory: DeleteCategory,
    val addCategory: AddCategory,
    val getCategory: GetCategory,
)