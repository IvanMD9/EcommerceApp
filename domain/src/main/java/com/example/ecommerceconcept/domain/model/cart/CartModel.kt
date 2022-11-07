package com.example.ecommerceconcept.data.model.cart

import com.example.ecommerceconcept.domain.model.cart.Basket

data class CartModel(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)