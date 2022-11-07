package com.example.ecommerceconcept.data.repository

import com.example.ecommerceconcept.data.model.cart.CartModel
import com.example.ecommerceconcept.data.model.detail.DetailProductModel
import com.example.ecommerceconcept.data.model.main.MainModel
import com.example.ecommerceconcept.data.remote.EcommerceApi
import com.example.ecommerceconcept.domain.repository.EcommerceRepository
import javax.inject.Inject

class EcommerceRepositoryImpl @Inject constructor(
    private val api: EcommerceApi
) : EcommerceRepository {

    override suspend fun getMainData(): MainModel {
        return api.getMainData()
    }

    override suspend fun getProductDetailData(): DetailProductModel {
        return api.getProductDetailData()
    }

    override suspend fun getCartData(): CartModel {
        return api.getCartData()
    }
}