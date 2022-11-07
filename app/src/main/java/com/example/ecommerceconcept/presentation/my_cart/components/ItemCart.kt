package com.example.ecommerceconcept.presentation.my_cart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceconcept.R
import coil.compose.rememberImagePainter
import com.example.ecommerceconcept.domain.model.cart.Basket
import com.example.ecommerceconcept.presentation.ui.theme.BackgroundCounterBasket
import com.example.ecommerceconcept.presentation.ui.theme.OrangeColorApp

@Composable
fun ItemCart(
    basket: Basket
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ItemImageBasket(images = basket.images)
            Spacer(modifier = Modifier.width(18.dp))
            ColumnNameAndPrice(name = basket.title, price = basket.price)
        }
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CounterBasket()
            Spacer(modifier = Modifier.width(18.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_delete_basket),
                contentDescription = null
            )
        }
    }
}

@Composable
fun ItemImageBasket(
    images: String
) {
    Box(
        modifier = Modifier
            .size(88.dp)
            .clip(RoundedCornerShape(15.dp))
    ) {
        Image(
            painter = rememberImagePainter(data = images),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ColumnNameAndPrice(
    name: String,
    price: Int
) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = Color.White,
            maxLines = 2,
            modifier = Modifier.width(150.dp)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "$$price",
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            color = OrangeColorApp,
            maxLines = 2
        )
    }
}

@Composable
fun CounterBasket() {
    var count by remember {
        mutableStateOf(0)
    }
    Box(
        modifier = Modifier
            .height(68.dp)
            .width(26.dp)
            .clip(RoundedCornerShape(26.dp))
            .background(BackgroundCounterBasket),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_minus_count),
                contentDescription = null,
                modifier = Modifier.clickable { count-- }
            )
            Text(
                text = "$count",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                color = Color.White
            )
            Image(
                painter = painterResource(id = R.drawable.ic_plus_count),
                contentDescription = null,
                modifier = Modifier.clickable { count++ }
            )
        }
    }
}