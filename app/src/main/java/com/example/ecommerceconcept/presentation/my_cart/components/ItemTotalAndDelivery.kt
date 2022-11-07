package com.example.ecommerceconcept.presentation.my_cart.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemTotalAndDelivery(
    total : Int,
    delivery : String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 55.dp, end = 35.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ColumnHeader()
        ColumnValue(total = total, delivery = delivery)
    }
}

@Composable
fun ColumnHeader() {
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = "Total", fontSize = 15.sp, fontWeight = FontWeight.Light, color = Color.White)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Delivery",
            fontSize = 15.sp,
            fontWeight = FontWeight.Light,
            color = Color.White
        )
    }
}

@Composable
fun ColumnValue(
    total : Int,
    delivery : String
) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = "$${total} us", fontSize = 15.sp, fontWeight = FontWeight.Medium, color = Color.White)
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = delivery,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}