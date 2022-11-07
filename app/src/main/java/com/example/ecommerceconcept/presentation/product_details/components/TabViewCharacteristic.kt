package com.example.ecommerceconcept.presentation.product_details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceconcept.presentation.product_details.ItemTabView
import com.example.ecommerceconcept.presentation.ui.theme.InactiveTab
import com.example.ecommerceconcept.presentation.ui.theme.NavigationMenuColor
import com.example.ecommerceconcept.presentation.ui.theme.OrangeColorApp


@Composable
fun TabViewCharacteristic(
    modifier: Modifier = Modifier,
    item: List<ItemTabView>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = InactiveTab
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = OrangeColorApp,
        modifier = modifier,
        divider = {},
        indicator = {
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(it[selectedTabIndex]),
                height = 3.dp
            )
        }
    ) {
        item.forEachIndexed { index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = NavigationMenuColor,
                unselectedContentColor = Color.Transparent,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }
            ) {
                Text(
                    text = item.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (selectedTabIndex == index) NavigationMenuColor else inactiveColor,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}