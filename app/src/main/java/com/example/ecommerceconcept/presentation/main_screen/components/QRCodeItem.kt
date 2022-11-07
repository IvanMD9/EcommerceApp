package com.example.ecommerceconcept.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.ui.theme.OrangeColorApp

@Composable
fun QRCode() {
    Column(verticalArrangement = Arrangement.Center) {
        Card(
            modifier = Modifier
                .size(35.dp)
                .clip(CircleShape),
            elevation = 0.dp,
            backgroundColor = OrangeColorApp
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_qr_code),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                alignment = Alignment.Center
            )
        }
    }
}