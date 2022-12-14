package com.example.ecommerceconcept.data.remote

import com.example.ecommerceconcept.data.model.cart.CartModel
import com.example.ecommerceconcept.data.model.detail.DetailProductModel
import com.example.ecommerceconcept.data.model.main.MainModel
import retrofit2.http.GET

interface EcommerceApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getMainData() : MainModel

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetailData() : DetailProductModel

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartData() : CartModel

    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }
}