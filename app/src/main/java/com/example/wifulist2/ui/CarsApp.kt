package com.example.wifulist2.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CarsApp() {
    val viewModel: CarsViewModel = viewModel()
    val carsUiState = viewModel.uiState.collectAsState().value


}