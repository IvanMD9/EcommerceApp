package com.example.ecommerceconcept.presentation.product_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.example.ecommerceconcept.data.model.detail.CapacityModel
import com.example.ecommerceconcept.domain.model.detail.SelectColorPhoneModel
import com.example.ecommerceconcept.presentation.main_screen.components.CustomButton
import com.example.ecommerceconcept.presentation.product_details.components.*
import com.example.ecommerceconcept.presentation.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.gowtham.ratingbar.RatingBar

@ExperimentalPagerApi
@Composable
fun ProductDetailWindow(
    viewModel: DetailProductViewModel = hiltViewModel(),
    navController: NavController
) {
    val stateDetail = viewModel.stateDetail.value
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    var selectedIndex by remember { mutableStateOf(CapacityModel()) }
    var selectedIndexColor by remember { mutableStateOf(SelectColorPhoneModel()) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundWindowApp)
    ) {
        stateDetail.detailProduct?.let { detailProduct ->
            LazyColumn {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 38.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomButton(
                            backgroundColor = NavigationMenuColor,
                            image = R.drawable.ic_back,
                            clickBtn = { navController.navigateUp() })
                        Text(
                            text = "Product Details",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = NavigationMenuColor
                        )
                        CustomButton(
                            backgroundColor = OrangeColorApp,
                            image = R.drawable.ic_shop_menu,
                            clickBtn = {})
                    }
                    Spacer(modifier = Modifier.height(30.dp))

                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(30.dp),
                        contentPadding = PaddingValues(horizontal = 30.dp)
                    ) {
                        items(detailProduct.images) {
                            ItemDetailProduct(image = it)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Surface(
                        modifier = Modifier
                            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                            .background(Color.White)
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            Spacer(modifier = Modifier.height(30.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 38.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = detailProduct.title,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = NavigationMenuColor
                                )
                                CustomButton(
                                    backgroundColor = NavigationMenuColor,
                                    image = R.drawable.ic_favourites_menu,
                                    clickBtn = {})
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            RatingBar(
                                value = detailProduct.rating.toFloat(),
                                onValueChange = {},
                                onRatingChanged = {},
                                modifier = Modifier.padding(start = 38.dp)
                            )
                            Spacer(modifier = Modifier.height(32.dp))
                            TabViewCharacteristic(
                                item = listOf(
                                    ItemTabView(title = "Shop"),
                                    ItemTabView(title = "Details"),
                                    ItemTabView(title = "Features")
                                ),
                                modifier = Modifier.padding(horizontal = 28.dp)
                            ) {
                                selectedTabIndex = it
                            }
                            Spacer(modifier = Modifier.height(32.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 38.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                ItemCharacteristic(
                                    image = R.drawable.ic_cpu_detail,
                                    title = detailProduct.CPU
                                )
                                ItemCharacteristic(
                                    image = R.drawable.ic_camera_detail,
                                    title = detailProduct.camera
                                )
                                ItemCharacteristic(
                                    image = R.drawable.ic_ssd_detail,
                                    title = detailProduct.ssd
                                )
                                ItemCharacteristic(
                                    image = R.drawable.ic_sd_detail,
                                    title = detailProduct.sd
                                )
                            }
                            Spacer(modifier = Modifier.height(30.dp))
                            Text(
                                text = "Select color and capacity",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = NavigationMenuColor,
                                modifier = Modifier.padding(start = 38.dp)
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 38.dp, end = 60.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                val itemColor: List<SelectColorPhoneModel> = listOf(
                                    SelectColorPhoneModel(color = ItemColorDetailOne),
                                    SelectColorPhoneModel(color = ItemColorDetailTwo)
                                )
                                LazyRow(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                                    items(items = itemColor) { selected ->
                                        ItemSelectedColorPhone(
                                            selectColorPhoneModel = SelectColorPhoneModel(
                                                color = selected.color
                                            ),
                                            clickColor = { selectedIndexColor = selected },
                                            image = when (selected) {
                                                selectedIndexColor -> R.drawable.ic_select_color
                                                else -> null
                                            }
                                        )
                                    }
                                }
                                val itemCapacity: List<CapacityModel> = listOf(
                                    CapacityModel(title = "128GB"),
                                    CapacityModel(title = "256GB"),
                                )
                                LazyRow {
                                    items(items = itemCapacity) { capacity ->
                                        ChipCapacity(
                                            text = CapacityModel(title = capacity.title),
                                            onClick = { selectedIndex = capacity },
                                            colorCard = when (capacity) {
                                                selectedIndex -> OrangeColorApp
                                                else -> Color.White
                                            },
                                            textColor = when (capacity) {
                                                selectedIndex -> Color.White
                                                else -> ColorTextInactiveCapacity
                                            }
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(28.dp))
                            Button(
                                onClick = {  },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(55.dp)
                                    .padding(horizontal = 30.dp),
                                colors = ButtonDefaults.buttonColors(OrangeColorApp),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 35.dp, end = 20.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "Add to Cart",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                    Text(
                                        text = "$${detailProduct.price}.00",
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(30.dp))
                        }
                    }
                }
            }
        }
    }
}