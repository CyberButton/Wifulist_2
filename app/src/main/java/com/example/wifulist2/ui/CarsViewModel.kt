package com.example.wifulist2.ui

import androidx.lifecycle.ViewModel
import com.example.wifulist2.data.Car
import com.example.wifulist2.data.CarsType
import com.example.wifulist2.data.carsCollection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CarsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CarsUiState())
    val uiState:StateFlow<CarsUiState> = _uiState

    // add init reset app

    fun changeCarType(carsType: CarsType) {
        _uiState.update {
            currentState ->
            currentState.copy(
                selectedCarType = carsType
            )
        }
    }

    fun changeCar(car: Car) {
        _uiState.update {
            currentState ->
            currentState.copy(
                selectedCar = car
            )
        }
    }
//    fun noWelcome(){
//        _uiState.update { current ->
//            current.copy(
//                isShowingHomePage = false
//            )
//        }
//    }

}