package com.vchepyolkin.hedgehogthings.feature_category.presentation.categories.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vchepyolkin.hedgehogthings.feature_category.domain.util.CategoryOrder
import com.vchepyolkin.hedgehogthings.feature_category.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    categoryOrder: CategoryOrder = CategoryOrder.Title(OrderType.Descending),
    onOrderChange: (CategoryOrder) -> Unit,
) {
    Column(modifier = modifier) {
        Row(Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Title",
                selected = categoryOrder is CategoryOrder.Title,
                onSelect = { onOrderChange(CategoryOrder.Title(categoryOrder.orderType)) }
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Color",
                selected = categoryOrder is CategoryOrder.Color,
                onSelect = { onOrderChange(CategoryOrder.Color(categoryOrder.orderType)) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        
        Row(modifier = Modifier.fillMaxWidth()) {
            DefaultRadioButton(
                text = "Ascending",
                selected = categoryOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(categoryOrder.copy(OrderType.Ascending))
                },
            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Descending",
                selected = categoryOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(categoryOrder.copy(OrderType.Descending))
                },
            )
        }

    }
}