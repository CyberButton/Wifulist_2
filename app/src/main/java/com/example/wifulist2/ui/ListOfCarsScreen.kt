package com.example.wifulist2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.wifulist2.data.Car
import com.example.wifulist2.data.CarsType
import com.example.wifulist2.data.carsCollection

@Composable
fun ListOfCarsScreen(
    onChoiceMadeCar: (Car) -> Unit,
    currentCarType: CarsType
) {
    // for testing
    //Text(text = "THIS IS LIST OF CARS SCREEN DISPLAYING WELL GJ!")

    Scaffold(topBar = {
        TopAppBar(
            modifier = Modifier
                .height(64.dp)
                .clip(
                    shape = RoundedCornerShape(
                        0.dp,
                        0.dp,
                        20.dp,
                        20.dp
                    )
                )
                .background(color = MaterialTheme.colors.background)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = currentCarType.name,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
        ) {
            when (currentCarType) {
                CarsType.DAILY_DRIVERS -> {
                    for (car in carsCollection.dailyDrivers) {
                        item {
                            CarCard(
                                onChoiceMadeCar,
                                car
                            )
                        }
                    }
                }
                CarsType.SPORTS_CARS -> {
                    for (car in carsCollection.sportsCars) {
                        item {
                            CarCard(
                                onChoiceMadeCar,
                                car
                            )
                        }
                    }
                }

                CarsType.HYPERCARS -> {
                    for (car in carsCollection.hyperCars) {
                        item {
                            CarCard(
                                onChoiceMadeCar,
                                car
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CarCard(
    onClick: (Car) -> Unit,
    carID: Car,
) {
    Card(modifier = Modifier.clickable {
        onClick(carID)
    }.padding(
        36.dp,
        28.dp,
        36.dp,
        0.dp
    ).fillMaxSize(),
        backgroundColor = MaterialTheme.colors.primary

    ) {
        Column(//horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = carID.image),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.height(150.dp).fillMaxWidth()
            )

            Text(
                text = carID.name,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Justify,
                color = MaterialTheme.colors.onPrimary
            )
        }

    }
}