package com.example.ecommerceconcept.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceconcept.presentation.main_screen.CategoryItem

@Composable
fun ItemCategory(
    modifier: Modifier = Modifier,
    category: CategoryItem,
    onClick: () -> Unit,
    colorImage: Color,
    colorText: Color,
    colorCard: Color,
) {
    Column(verticalArrangement = Arrangement.Center) {
        Card(
            modifier = modifier
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onClick()
                }
                .size(70.dp)
                .clip(CircleShape),
            elevation = 0.dp,
            backgroundColor = colorCard
        ) {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                colorFilter = ColorFilter.tint(color = colorImage),
                alignment = Alignment.Center
            )
        }
        Spacer(modifier = Modifier.height(7.dp))
        Text(
            text = category.text,
            color = colorText,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}