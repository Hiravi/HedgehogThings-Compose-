package com.vchepyolkin.hedgehogthings.feature_note.presentation.categories.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vchepyolkin.hedgehogthings.R


@Composable
fun TopBar(
    title: String,
    onBack: () -> Unit,
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp,
        backgroundColor = Color.White,
    ) {

        IconButton(
            onClick = onBack,
            modifier = Modifier
                .padding(start = 10.dp)
                .size(18.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Button back",
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.h6
        )


    }
}


    

