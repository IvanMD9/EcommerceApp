package com.example.ecommerceconcept.domain.repository

import com.example.ecommerceconcept.data.model.cart.CartModel
import com.example.ecommerceconcept.data.model.detail.DetailProductModel
import com.example.ecommerceconcept.data.model.main.MainModel

interface EcommerceRepository {

    suspend fun getMainData() : MainModel
    suspend fun getProductDetailData() : DetailProductModel
    suspend fun getCartData() : CartModel
}