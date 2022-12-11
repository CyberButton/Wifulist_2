package com.example.wifulist2.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * enum values that represent the screens in the app
 */
enum class CarsScreens(val title: String) {
    WELCOME(title = "welcome"),
    CHOOSE_CAR(title =  "chose car"),
    CAR_SPECS(title = "specs")
}

@Composable
fun MainScreen(
    viewModel: CarsViewModel = viewModel()
) {
    //println("I am in main")
    val uiState by viewModel.uiState.collectAsState()
    // Create NavController
    val navController = rememberNavController()
    Scaffold() {
        innerpadding ->
        NavHost(
            navController = navController,
            startDestination = CarsScreens.WELCOME.title,
            modifier = Modifier.padding(innerpadding)
        ) {
            //println("I am in NavHost")
            // was looking at cupcake and LunchTray
            composable(route = CarsScreens.WELCOME.title) {
                //println("I started composing welcome screen")
                WelcomeScreenWithExpandedListOfCarTypes(
                    onChoiceMade = {
                        viewModel.changeCarType(it)
                        navController.navigate(CarsScreens.CHOOSE_CAR.title)
                    }
                )
            }
            composable(route = CarsScreens.CHOOSE_CAR.title) {
                ListOfCarsScreen(
                    onChoiceMadeCar = {
                    viewModel.changeCar(it)
                    navController.navigate(CarsScreens.CAR_SPECS.title)
                },
                    currentCarType = uiState.selectedCarType
                )
            }
            composable(route = CarsScreens.CAR_SPECS.title) {
                CarSpecsScreen(
                    currentCarSpec = uiState.selectedCar
                )
            }
        }
    }
    
}