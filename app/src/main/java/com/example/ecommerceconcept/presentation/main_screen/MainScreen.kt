package com.example.ecommerceconcept.presentation.main_screen

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.main_screen.components.*
import com.example.ecommerceconcept.presentation.navigation.NavigationScreen
import com.example.ecommerceconcept.presentation.ui.theme.BackgroundWindowApp
import com.example.ecommerceconcept.presentation.ui.theme.ColorIconCategoryInactive
import com.example.ecommerceconcept.presentation.ui.theme.NavigationMenuColor
import com.example.ecommerceconcept.presentation.ui.theme.OrangeColorApp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun MainWindow(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = BackgroundWindowApp,
                contentPadding = PaddingValues(horizontal = 16.dp),
                elevation = 0.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Zihuatanejo, Gro",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium,
                            color = NavigationMenuColor
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_select_location),
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.End
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_filter),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(end = 35.dp)
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) { viewModel.onEventMain(EventMainScreen.ClickFilter) }
                        )
                    }
                }
            }
        }
    ) {
        val state = viewModel.stateMain.value
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundWindowApp)
                .padding(bottom = 65.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Row(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Select Category",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                color = NavigationMenuColor,
                                modifier = Modifier.padding(start = 18.dp)
                            )
                        }
                        Row(horizontalArrangement = Arrangement.End) {
                            Text(
                                text = "view all",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Light,
                                color = OrangeColorApp,
                                modifier = Modifier.padding(end = 35.dp)
                            )
                        }
                    }
                }
                item {
                    val categories: List<CategoryItem> = listOf(
                        CategoryItem(image = R.drawable.ic_category_1, text = "Phones"),
                        CategoryItem(image = R.drawable.ic_category_2, text = "Books"),
                        CategoryItem(image = R.drawable.ic_category_3, text = "Health"),
                        CategoryItem(image = R.drawable.ic_category_4, text = "Computer"),
                        CategoryItem(image = R.drawable.ic_category_5, text = "Phones New")
                    )

                    val listCategory = rememberLazyListState()
                    var selectedIndex by remember { mutableStateOf(CategoryItem()) }
                    Spacer(modifier = Modifier.height(24.dp))
                    LazyRow(
                        state = listCategory,
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 28.dp)
                    ) {
                        items(items = categories) { category ->
                            ItemCategory(
                                onClick = {
                                    selectedIndex = category
                                },
                                category = CategoryItem(
                                    image = category.image,
                                    text = category.text
                                ),
                                colorText = when (category) {
                                    selectedIndex -> OrangeColorApp
                                    else -> NavigationMenuColor
                                },
                                colorCard = when (category) {
                                    selectedIndex -> OrangeColorApp
                                    else -> Color.White
                                },
                                colorImage = when (category) {
                                    selectedIndex -> Color.White
                                    else -> ColorIconCategoryInactive
                                }
                            )
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(35.dp))
                    Row(Modifier.padding(start = 32.dp, end = 38.dp)) {
                        Row(Modifier.weight(7f)) {
                            CustomTextField(
                                text = state.text,
                                onValueChange = {
                                    viewModel.onEventMain(
                                        EventMainScreen.EnteredText(
                                            it
                                        )
                                    )
                                },
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_search),
                                        contentDescription = null,
                                        modifier = Modifier.padding(end = 15.dp)
                                    )
                                })
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Row(Modifier.weight(1f)) {
                            QRCode()
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Row(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Hot sales",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold,
                                color = NavigationMenuColor,
                                modifier = Modifier.padding(start = 18.dp)
                            )
                        }
                        Row(horizontalArrangement = Arrangement.End) {
                            Text(
                                text = "see more",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Light,
                                color = OrangeColorApp,
                                modifier = Modifier.padding(end = 35.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(30.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        state.dataHotSales?.let {
                            items(it.home_store) { hotData ->
                                ItemHotSales(homeStore = hotData)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    if (state.isVisibleHeaderProducts) {
                        AnimatedVisibility(visible = state.isVisibleHeaderProducts) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Row(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "Best Seller",
                                        fontSize = 25.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = NavigationMenuColor,
                                        modifier = Modifier.padding(start = 18.dp)
                                    )
                                }
                                Row(horizontalArrangement = Arrangement.End) {
                                    Text(
                                        text = "see more",
                                        fontSize = 15.sp,
                                        fontWeight = FontWeight.Light,
                                        color = OrangeColorApp,
                                        modifier = Modifier.padding(end = 35.dp)
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    Box {
                        if (state.isVisibleFilterSection) {
                            AnimatedVisibility(visible = state.isVisibleFilterSection) {
                                FilterOptions(
                                    onClickExit = {
                                        viewModel.onEventMain(EventMainScreen.ClickFilterExit)
                                    },
                                    onClickDone = {
                                        viewModel.onEventMain(EventMainScreen.ClickFilterDone)
                                    })
                            }
                        } else if (state.isVisibleProductsSection) {
                            AnimatedVisibility(
                                visible = state.isVisibleProductsSection
                            ) {
                                val number = 2
                                state.dataHotSales?.let {
                                    this@LazyColumn.items(it.best_seller.chunked(number)) { products ->
                                        Row(
                                            modifier = Modifier.padding(
                                                start = 14.dp,
                                                end = 14.dp,
                                                bottom = 12.dp
                                            ),
                                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                                        ) {
                                            for ((index, item) in products.withIndex()) {
                                                Box(
                                                    modifier = Modifier.fillMaxWidth(1f / (number - index))
                                                ) {
                                                    ItemProduct(
                                                        bestSeller = item,
                                                        onDetailInfo = {
                                                            navController.navigate(NavigationScreen.DetailsScreen.route)
                                                        }
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
