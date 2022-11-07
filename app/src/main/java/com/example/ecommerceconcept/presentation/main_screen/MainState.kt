package com.example.ecommerceconcept.presentation.main_screen

import com.example.ecommerceconcept.data.model.main.MainModel

data class MainState(
    val dataHotSales : MainModel? = null,
    val isLoading : Boolean = false,
    val text : String = "",
    val error : String = "",
    val isVisibleFilterSection : Boolean = false,
    val isVisibleProductsSection : Boolean = true,
    val isVisibleHeaderProducts : Boolean = true
)