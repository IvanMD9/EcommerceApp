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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.data.model.main.BestSeller
import com.example.ecommerceconcept.presentation.ui.theme.BackgroundWindowApp
import com.example.ecommerceconcept.presentation.ui.theme.NavigationMenuColor
import com.example.ecommerceconcept.presentation.ui.theme.OldPriceProduct

@Composable
fun ItemProduct(
    bestSeller: BestSeller,
    onDetailInfo: () -> Unit
) {
    Card(
        modifier = Modifier
            .background(BackgroundWindowApp)
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onDetailInfo() }
            .height(230.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp
    ) {
        Column {
            Box {
                Image(
                    painter = rememberImagePainter(data = bestSeller.picture),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp),
                    contentScale = ContentScale.Crop
                )
                ShapeAddFavourites(
                    image = if (bestSeller.is_favorites) R.drawable.ic_add_fav else R.drawable.ic_not_add_fav,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 12.dp, bottom = 110.dp)
                )
            }
            Box {
                Column {
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(modifier = Modifier.padding(start = 20.dp)) {
                        Text(
                            text = "$${bestSeller.price_without_discount}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = NavigationMenuColor
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "$${bestSeller.discount_price}",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium,
                            style = TextStyle(textDecoration = TextDecoration.LineThrough),
                            color = OldPriceProduct,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = bestSeller.title,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = NavigationMenuColor,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ShapeAddFavourites(
    image: Int,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .size(30.dp)
            .background(Color.Transparent),
        elevation = 10.dp,
        shape = CircleShape
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