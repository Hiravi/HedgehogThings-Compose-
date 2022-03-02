package com.vchepyolkin.hedgehogthings
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import com.vchepyolkin.hedgehogthings.navigation.NavComposeApp
import com.vchepyolkin.hedgehogthings.ui.diary.Diary
import com.vchepyolkin.hedgehogthings.ui.home.Home
import com.vchepyolkin.hedgehogthings.ui.theme.HedgehogThingsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            HedgehogThingsTheme {
                Diary()
            }
        }
    }
}



