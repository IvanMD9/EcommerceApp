package com.example.ecommerceconcept.presentation.product_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceconcept.data.model.detail.CapacityModel

@Composable
fun ChipCapacity(
    text: CapacityModel,
    onClick: () -> Unit,
    colorCard: Color,
    textColor: Color
) {
    Box(
        modifier = Modifier
            .width(70.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colorCard)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(text = text.title, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = textColor)
    }
}