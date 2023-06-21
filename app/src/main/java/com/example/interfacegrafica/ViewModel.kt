// Vek Histories
// Victor Cardoso

package com.example.interfacegrafica

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewModel: ViewModel() {

    private val _contadorViewModel = MutableStateFlow(0)
    val contadorView: StateFlow<Int> get() = _contadorViewModel

    fun incrementContador(){
        _contadorViewModel.value = _contadorViewModel.value + 1
    }

    fun decrementContador(){
        _contadorViewModel.value = _contadorViewModel.value - 1
    }

    fun getContadorViewModel(): Int {
        return _contadorViewModel.value
    }

}