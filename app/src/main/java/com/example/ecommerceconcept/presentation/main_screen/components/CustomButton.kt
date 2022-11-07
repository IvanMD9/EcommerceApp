package com.example.ecommerceconcept.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    backgroundColor: Color,
    image: Int,
    clickBtn: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(38.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { clickBtn() },
        shape = RoundedCornerShape(10.dp),
        backgroundColor = backgroundColor
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            alignment = Alignment.Center
        )
    }
}