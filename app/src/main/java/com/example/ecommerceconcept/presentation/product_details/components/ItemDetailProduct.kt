package com.example.ecommerceconcept.presentation.product_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ItemDetailProduct(
    image: String
) {
    Card(
        modifier = Modifier
            .height(320.dp)
            .width(260.dp),
        elevation = 20.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}