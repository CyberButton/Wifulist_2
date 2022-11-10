package com.example.wifulist2.ui

import androidx.lifecycle.ViewModel
import com.example.wifulist2.data.Car
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CarsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CarsUiState())
    val uiState:StateFlow<CarsUiState> = _uiState

    // add init reset app

}