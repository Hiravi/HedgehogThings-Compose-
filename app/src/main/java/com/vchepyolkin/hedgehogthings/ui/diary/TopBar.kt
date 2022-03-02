package com.vchepyolkin.hedgehogthings.ui.diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vchepyolkin.hedgehogthings.R

@Preview
@Composable
fun TopBar() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp,
        color = Color.White,
    ) {
        Row(

            modifier = Modifier
                .height(50.dp)
                .padding(start = 8.dp),
            verticalAlignment = CenterVertically,
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Button back",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(18.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))
            
            Text(text = "Категории")

        }

    }
}