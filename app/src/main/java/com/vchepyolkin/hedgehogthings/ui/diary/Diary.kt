package com.vchepyolkin.hedgehogthings.ui.diary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun Diary() {
    Surface(modifier = Modifier.fillMaxSize()) {

        ConstraintLayout {
            val addCategoryButton = createRef()
            val topBar = createRef()

            TopBar()

            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.constrainAs(addCategoryButton) {
                    bottom.linkTo(parent.bottom, margin = 48.dp)
                    end.linkTo(parent.end, margin = 24.dp)

                }
            ) {

            }


        }

    }
}

