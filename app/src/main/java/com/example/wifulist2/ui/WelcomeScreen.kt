package com.example.wifulist2.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun WelcomeScreenWithExpandedListOfCarTypes(
    onChoiceMade: (CarsType) -> Unit
) {
    val visible by remember {
        mutableStateOf(true)
    }
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
            AnimatedVisibility(visible = visible) {

             Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = "Choose a car type",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onPrimary
                )
            }
            }
        }
    }
    )
    { padding ->
        Column() {
            Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .padding(padding)
                    .clip(
                        RoundedCornerShape(
                            20.dp,
                            20.dp,
                            0.dp,
                            0.dp
                        )
                    )
                    .background(color = MaterialTheme.colors.primary)
                    .fillMaxSize()
            ) {
                Column() {
                    CardWithCarType(cartype = CarsType.DAILY_DRIVERS, onChoiceMade = onChoiceMade)
                    CardWithCarType(cartype = CarsType.SPORTS_CARS, onChoiceMade = onChoiceMade)
                    CardWithCarType(cartype = CarsType.HYPERCARS, onChoiceMade = onChoiceMade)
                }
            }
        }
    }
}

@Composable
fun CardWithCarType(
    cartype: CarsType,
    onChoiceMade: (CarsType) -> Unit
) {
    when (cartype) {
        CarsType.DAILY_DRIVERS -> {
            CardContent(
                cartype = "Daily Drivers",
                carimage = carsCollection.dailyDrivers,
                forNavigation = cartype,
                onClick = onChoiceMade
            )
        }
        CarsType.SPORTS_CARS -> {
            CardContent(
                cartype = "Sports Cars",
                carimage = carsCollection.sportsCars,
                forNavigation = cartype,
                onClick = onChoiceMade
            )
        }
        CarsType.HYPERCARS -> {
            CardContent(
                cartype = "Hyper Cars",
                carimage = carsCollection.hyperCars,
                forNavigation = cartype,
                onClick = onChoiceMade
            )
        }
    }
}

@Composable
fun CardContent(
    cartype: String,
    carimage: List<Car>,
    forNavigation: CarsType,
    modifier: Modifier = Modifier,
    onClick: (CarsType) -> Unit
) {
    Box() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .padding(
                        36.dp,
                        28.dp,
                        36.dp,
                        0.dp
                    )
                    .aspectRatio(16f / 9f)
                    .fillMaxSize()
                    .clickable {
                        onClick(forNavigation)
                    }
            ) {
                Image(
                    painter = painterResource(id = carimage[2].image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.clip(
                        shape = CutCornerShape(
                            0,
                            0,
                            0,
                            0
                        )
                    )
                )
                Image(
                    painter = painterResource(id = carimage[1].image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.clip(
                        shape = CutCornerShape(
                            100,
                            0,
                            0,
                            0
                        )
                    )
                )
                Image(
                    painter = painterResource(id = carimage[0].image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.clip(
                        shape = CutCornerShape(
                            100,
                            0,
                            100,
                            0
                        )
                    )
                )
            }
            Text(
                text = cartype,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Justify,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}

