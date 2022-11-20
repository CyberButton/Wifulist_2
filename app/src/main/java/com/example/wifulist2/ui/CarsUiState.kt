package com.example.wifulist2.ui

import android.content.res.Configuration
import com.example.wifulist2.data.Car
import com.example.wifulist2.data.CarsType
import com.example.wifulist2.data.carsCollection

data class CarsUiState(
    //val isShowingHomePage: Boolean = true,
    val currentOrientation: Int = Configuration.ORIENTATION_PORTRAIT,
    val selectedCarType: CarsType = CarsType.DAILY_DRIVERS,
    val selectedCar: Car = carsCollection.dailyDrivers[0]
)
{

}