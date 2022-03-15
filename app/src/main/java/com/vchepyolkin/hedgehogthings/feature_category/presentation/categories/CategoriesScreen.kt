package com.vchepyolkin.hedgehogthings.feature_category.presentation.categories

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.vchepyolkin.hedgehogthings.R
import com.vchepyolkin.hedgehogthings.feature_category.domain.model.Category


@Composable
@ExperimentalFoundationApi
fun CategoriesScreen(categories: List<Category>) {
    Surface(modifier = Modifier.fillMaxSize()) {

        ConstraintLayout {
            val addCategoryButton = createRef()
            val topBar = createRef()
            val grid = createRef()

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                content = {
                    items(categories.size) { item ->
                        Card(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            Text(text = categories[item].title)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(grid) {
                        top.linkTo(topBar.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
            )

            TopBar(
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)

                },
            )


            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = Color.White,
                modifier = Modifier.constrainAs(addCategoryButton) {
                    bottom.linkTo(parent.bottom, margin = 48.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                },
            ) {
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(R.drawable.ic_plus),
                    contentDescription = "Add category button",
                )

            }


        }

    }
}



