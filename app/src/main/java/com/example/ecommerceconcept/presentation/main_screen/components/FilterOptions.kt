package com.example.ecommerceconcept.presentation.main_screen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.ui.theme.BackgroundBorderTextFieldFilter
import com.example.ecommerceconcept.presentation.ui.theme.NavigationMenuColor
import com.example.ecommerceconcept.presentation.ui.theme.OrangeColorApp

@Composable
fun FilterOptions(
    onClickExit: () -> Unit,
    onClickDone: () -> Unit
) {
    val brand = listOf("Samsung", "Xiaomi", "Huawei", "iPhone", "Motorola")
    val price = listOf(
        "$0 - $300",
        "$300 - $500",
        "$500 - $800",
        "$800 - $1500",
        "$1500 - $5000",
        "$5000 - $10000"
    )
    val size = listOf("4.5 to 5.5 inches")
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 22.dp)
            .background(Color.White),
        elevation = 20.dp,
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp, start = 44.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomButton(
                    backgroundColor = NavigationMenuColor,
                    image = R.drawable.ic_exit_btn,
                    clickBtn = { onClickExit() }
                )
                Text(
                    text = "Filter options",
                    color = NavigationMenuColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                ButtonDone(clickBtn = { onClickDone() })
            }
            Spacer(modifier = Modifier.height(44.dp))
            TextHeader(header = "Brand")
            Spacer(modifier = Modifier.height(12.dp))
            TextFieldSelect(categories = brand)
            Spacer(modifier = Modifier.height(12.dp))
            TextHeader(header = "Price")
            Spacer(modifier = Modifier.height(12.dp))
            TextFieldSelect(categories = price)
            Spacer(modifier = Modifier.height(12.dp))
            TextHeader(header = "Size")
            Spacer(modifier = Modifier.height(12.dp))
            TextFieldSelect(categories = size)
            Spacer(modifier = Modifier.height(44.dp))
        }
    }
}

@Composable
fun ButtonDone(
    clickBtn: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(85.dp)
            .height(38.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { clickBtn() },
        shape = RoundedCornerShape(10.dp),
        backgroundColor = OrangeColorApp
    ) {
        Text(
            text = "Done",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Composable
fun TextHeader(
    header: String
) {
    Text(
        text = header,
        color = NavigationMenuColor,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 46.dp)
    )
}

@Composable
fun TextFieldSelect(
    categories: List<String>
) {
    var text by remember {
        mutableStateOf("")
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    var textFieldSize by remember {
        mutableStateOf(Size.Zero)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    Column(
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = { expanded = false })
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 44.dp, end = 32.dp)
                        .height(52.dp)
                        .border(
                            width = 1.dp,
                            color = BackgroundBorderTextFieldFilter,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .onGloballyPositioned { coordinates ->
                            textFieldSize = coordinates.size.toSize()
                        },
                    value = text,
                    onValueChange = {
                        text = it
                        expanded = true
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black
                    ),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = 16.sp
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = Icons.Rounded.KeyboardArrowDown,
                                contentDescription = "arrow",
                                tint = Color.Black
                            )
                        }
                    }
                )
            }
        }
    }
    AnimatedVisibility(visible = expanded) {
        Card(
            modifier = Modifier
                .padding(start = 44.dp, end = 32.dp)
                .width(textFieldSize.width.dp),
            elevation = 15.dp,
            shape = RoundedCornerShape(10.dp)
        ) {

            LazyColumn(
                modifier = Modifier.heightIn(max = 150.dp),
            ) {

                if (text.isNotEmpty()) {
                    items(
                        categories.filter {
                            it.lowercase()
                                .contains(text.lowercase()) || it.lowercase()
                                .contains("")
                        }
                    ) {
                        CategoryItems(title = it) { title ->
                            text = title
                            expanded = false
                        }
                    }
                } else {
                    items(categories) {
                        CategoryItems(title = it) { title ->
                            text = title
                            expanded = false
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItems(
    title: String,
    onSelect: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onSelect(title)
            }
            .padding(10.dp)
    ) {
        Text(text = title, fontSize = 16.sp)
    }
}