package com.example.wifulist2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.wifulist2.data.Car
import com.example.wifulist2.data.CarsType
import com.example.wifulist2.data.carsCollection

@Composable
fun WelcomeScreenWithExpandedListOfCarTypes(

) {
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
                    text = "Choose a car type",
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
    )
    { padding ->
        Column() {
            Spacer(modifier = Modifier.height(20.dp))
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
            ) {
                Column() {
                    CardWithCarType(cartype = CarsType.DAILY_DRIVERS)
//              CardWithCarType(cartype = CarsType.SPORTS_CARS)
                    CardWithCarType(cartype = CarsType.HYPERCARS)
                }
            }
        }
    }
}

@Composable
fun CardWithCarType(
    cartype: CarsType
) {
    when (cartype) {
        CarsType.DAILY_DRIVERS -> {
            CardContent(
                cartype = "Daily Drivers",
                carimage = carsCollection.dailyDrivers
            ) {}
        }
        CarsType.SPORTS_CARS -> {
//            CardContent(
//                cartype = "",
//                carimage =
//            ) {}
        }
        CarsType.HYPERCARS -> {
            CardContent(
                cartype = "HyperCars",
                carimage = carsCollection.hyperCars
            ) {}
        }
    }
}

@Composable
fun CardContent(
    cartype: String,
    carimage: List<Car>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(modifier = Modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .padding(
                        36.dp,
                        36.dp,
                        36.dp,
                        0.dp
                    )
                    .aspectRatio(16f / 9f)
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
