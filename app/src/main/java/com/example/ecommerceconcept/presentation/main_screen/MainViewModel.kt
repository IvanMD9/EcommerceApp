package com.example.ecommerceconcept.presentation.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceconcept.domain.use_case.MainScreenUseCase
import com.example.ecommerceconcept.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainScreenUseCase: MainScreenUseCase
) : ViewModel() {

    private val _stateMain = mutableStateOf(MainState())
    val stateMain : State<MainState> = _stateMain

    init {
        getMainData()
    }

    private fun getMainData() {
        mainScreenUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _stateMain.value = MainState(isLoading = true)
                }
                is Resource.Success -> {
                    _stateMain.value = MainState(dataHotSales = result.data)
                }
                is Resource.Error -> {
                    _stateMain.value = MainState(error = result.message ?: "An unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEventMain(eventMainScreen: EventMainScreen) {
        when (eventMainScreen) {
            is EventMainScreen.EnteredText -> {
                _stateMain.value = stateMain.value.copy(
                    text = eventMainScreen.text
                )
            }
            is EventMainScreen.ClickFilter -> {
                _stateMain.value = stateMain.value.copy(
                    isVisibleFilterSection = !stateMain.value.isVisibleFilterSection,
                    isVisibleProductsSection = !stateMain.value.isVisibleProductsSection,
                    isVisibleHeaderProducts = !stateMain.value.isVisibleHeaderProducts
                )
            }
            is EventMainScreen.ClickFilterExit -> {
                _stateMain.value = stateMain.value.copy(
                    isVisibleFilterSection = !stateMain.value.isVisibleFilterSection,
                    isVisibleProductsSection = !stateMain.value.isVisibleProductsSection,
                    isVisibleHeaderProducts = !stateMain.value.isVisibleHeaderProducts
                )
            }
            is EventMainScreen.ClickFilterDone -> {
                _stateMain.value = stateMain.value.copy(
                    isVisibleFilterSection = !stateMain.value.isVisibleFilterSection,
                    isVisibleProductsSection = !stateMain.value.isVisibleProductsSection,
                    isVisibleHeaderProducts = !stateMain.value.isVisibleHeaderProducts
                )
            }
        }
    }
}