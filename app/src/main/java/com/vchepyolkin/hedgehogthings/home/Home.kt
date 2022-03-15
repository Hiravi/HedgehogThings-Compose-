package com.vchepyolkin.hedgehogthings.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vchepyolkin.hedgehogthings.R

@Preview
@Composable
fun Home() {
    Scaffold() {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier.size(128.dp).border(2.dp, Color.Black),
            ) {

                Image(
                    painter = painterResource(R.drawable.ic_diary),
                    contentDescription = "Online diary",
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                modifier = Modifier.size(128.dp).border(2.dp, Color.Black),
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_album),
                    contentDescription = "Online gallery",
                )
            }
        }
    }
}