package com.example.ecommerceconcept.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ecommerceconcept.presentation.ui.theme.NavigationMenuColor

@Composable
fun ProfileWindow() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "ProfileWindow",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = NavigationMenuColor
        )
    }
}