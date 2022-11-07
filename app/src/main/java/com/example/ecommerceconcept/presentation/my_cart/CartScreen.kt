package com.example.ecommerceconcept.presentation.my_cart

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.main_screen.components.CustomButton
import com.example.ecommerceconcept.presentation.my_cart.components.ItemCart
import com.example.ecommerceconcept.presentation.my_cart.components.ItemTotalAndDelivery
import com.example.ecommerceconcept.presentation.ui.theme.*

@Composable
fun CartWindow(
    viewModel: CartViewModel = hiltViewModel(),
    navController: NavController
) {
    val stateCart = viewModel.stateCart.value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundWindowApp)
    ) {
        stateCart.listCart?.let { basket ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 42.dp, end = 46.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    CustomButton(
                        backgroundColor = NavigationMenuColor,
                        image = R.drawable.ic_back,
                        clickBtn = { navController.navigateUp() })
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Add address",
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        color = NavigationMenuColor
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    CustomButton(
                        backgroundColor = OrangeColorApp,
                        image = R.drawable.ic_location_basket,
                        clickBtn = {})
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "My Cart",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = NavigationMenuColor,
                modifier = Modifier.padding(start = 42.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .fillMaxHeight(),
                color = NavigationMenuColor
            ) {
                Column {
                    Spacer(modifier = Modifier.height(60.dp))
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(40.dp)) {
                        items(basket.basket) {
                            ItemCart(basket = it)
                        }
                    }
                    Spacer(modifier = Modifier.height(105.dp))
                    Divider(
                        modifier = Modifier
                            .height(2.dp)
                            .background(Divider2DPBasket)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    ItemTotalAndDelivery(total = basket.total, delivery = basket.delivery)
                    Spacer(modifier = Modifier.height(25.dp))
                    Divider(
                        modifier = Modifier
                            .height(1.dp)
                            .background(Divider1DPBasket)
                    )
                    Spacer(modifier = Modifier.height(45.dp))
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .padding(start = 44.dp, end = 44.dp),
                        colors = ButtonDefaults.buttonColors(OrangeColorApp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Checkout",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}