package com.vchepyolkin.hedgehogthings
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vchepyolkin.hedgehogthings.models.Category


import com.vchepyolkin.hedgehogthings.presentation.diary.Diary
import com.vchepyolkin.hedgehogthings.ui.theme.HedgehogThingsTheme

class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HedgehogThingsTheme {

            }
        }
    }
}

@Preview
@Composable
@ExperimentalFoundationApi
fun Show() {
    val categories = mutableListOf<Category>(
        Category(
            "Books",
            0,
            Category.categoryColors[1]
        ),
        Category(
            "Movies",
            1,
            Category.categoryColors[2]
        ),
        Category("People", 2, Category.categoryColors[0])
    )

    HedgehogThingsTheme {
        Diary(categories)
    }
}



