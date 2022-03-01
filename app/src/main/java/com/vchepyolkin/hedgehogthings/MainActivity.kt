package com.vchepyolkin.hedgehogthings
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade


import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.vchepyolkin.hedgehogthings.ui.home.Home

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Home()
        }


    }
}



