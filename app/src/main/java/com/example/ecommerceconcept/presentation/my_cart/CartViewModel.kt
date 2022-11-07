package com.example.ecommerceconcept.presentation.my_cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.use_case.CartScreenUseCase
import com.example.ecommerceconcept.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartScreenUseCase: CartScreenUseCase
) : ViewModel () {

    private val _stateCart = mutableStateOf(StateCart())
    val stateCart : State<StateCart> = _stateCart

    init {
        getCart()
    }

    private fun getCart() {
        cartScreenUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _stateCart.value = StateCart(isLoading = true)
                }
                is Resource.Success -> {
                    _stateCart.value = StateCart(listCart = result.data)
                }
                is Resource.Error -> {
                    _stateCart.value = StateCart(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}