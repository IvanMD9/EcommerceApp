package com.example.ecommerceconcept.presentation.product_details

import com.example.ecommerceconcept.data.model.detail.DetailProductModel

data class StateDetailProduct(
    val detailProduct : DetailProductModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)
