package com.example.ecommerceconcept.presentation.main_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.presentation.ui.theme.NavigationMenuColor
import com.example.ecommerceconcept.presentation.ui.theme.OrangeColorApp
import com.example.ecommerceconcept.presentation.ui.theme.TextHintColorSearch

@Composable
fun SearchBar(
    text: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontSize = 17.sp),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier.padding(start = 34.dp)
            )
        },
        modifier = Modifier
            .padding(start = 32.dp)
            .height(50.dp)
            .background(Color.White, RoundedCornerShape(50.dp)),
        placeholder = {
            Text(
                text = "Search",
                modifier = Modifier.padding(start = 18.dp)
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color.DarkGray
        )
    )
}

@Composable
fun CustomTextField(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Search"
) {
    BasicTextField(modifier = modifier
        .background(Color.White, RoundedCornerShape(50.dp))
        .height(35.dp)
        .padding(start = 32.dp),
        value = text,
        onValueChange = {
            onValueChange(it)
        },
        singleLine = true,
        cursorBrush = SolidColor(OrangeColorApp),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colors.onSurface,
            fontSize = 14.sp
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box {
                    if (text.isEmpty()) Text(
                        placeholderText,
                        style = LocalTextStyle.current.copy(
                            color = TextHintColorSearch,
                            fontSize = 14.sp
                        )
                    )
                    innerTextField()
                }
            }
        }
    )
}