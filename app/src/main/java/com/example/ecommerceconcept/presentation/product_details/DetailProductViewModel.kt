package com.example.ecommerceconcept.presentation.product_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.use_case.DetailProductScreenUseCase
import com.example.ecommerceconcept.presentation.main_screen.MainState
import com.example.ecommerceconcept.utils.Constants
import com.example.ecommerceconcept.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val detailProductScreenUseCase: DetailProductScreenUseCase
) : ViewModel() {
    private val _stateDetail = mutableStateOf(StateDetailProduct())
    val stateDetail: State<StateDetailProduct> = _stateDetail

    init {
        getDetailProduct()
    }

    private fun getDetailProduct() {
        detailProductScreenUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _stateDetail.value = StateDetailProduct(isLoading = true)
                }
                is Resource.Success -> {
                    _stateDetail.value = StateDetailProduct(detailProduct = result.data)
                }
                is Resource.Error -> {
                    _stateDetail.value =
                        StateDetailProduct(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}