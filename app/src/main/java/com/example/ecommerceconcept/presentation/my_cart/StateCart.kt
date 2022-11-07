package com.example.ecommerceconcept.presentation.my_cart

import com.example.ecommerceconcept.data.model.cart.CartModel

data class StateCart(
    val listCart : CartModel? = null,
    val isLoading : Boolean = false,
    val error : String = ""
)
