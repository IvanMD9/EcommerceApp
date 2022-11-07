package com.example.ecommerceconcept.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.ecommerceconcept.data.model.main.HomeStore
import com.example.ecommerceconcept.presentation.ui.theme.NavigationMenuColor
import com.example.ecommerceconcept.presentation.ui.theme.OrangeColorApp

@Composable
fun ItemHotSales(
    homeStore: HomeStore
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(360.dp)
            .height(180.dp),
        elevation = 0.dp
    ) {
        Image(
            painter = rememberImagePainter(data = homeStore.picture),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.padding(start = 25.dp)) {
            Spacer(modifier = Modifier.height(15.dp))
            if (homeStore.is_new) NewProducts() else false
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = homeStore.title,
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = homeStore.subtitle,
                color = Color.White,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { }, modifier = Modifier
                    .width(100.dp)
                    .height(30.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "Buy now!",
                    color = NavigationMenuColor,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun NewProducts() {
    Column(verticalArrangement = Arrangement.Center) {
        Card(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape),
            elevation = 0.dp,
            backgroundColor = OrangeColorApp
        ) {
            Text(
                text = "New",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}