package com.example.ecommerceconcept.domain.use_case

import com.example.ecommerceconcept.data.model.cart.CartModel
import com.example.ecommerceconcept.domain.repository.EcommerceRepository
import com.example.ecommerceconcept.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class CartScreenUseCase @Inject constructor(
    private val repository: EcommerceRepository
) {
    operator fun invoke() : Flow<Resource<CartModel>> = flow {
        try {
            emit(Resource.Loading())
            val cart = repository.getCartData()
            emit(Resource.Success(cart))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e : java.io.IOException) {
            emit(Resource.Error("Check you connection Internet"))
        }
    }
}