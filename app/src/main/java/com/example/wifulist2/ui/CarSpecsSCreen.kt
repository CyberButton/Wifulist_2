package com.example.wifulist2.ui

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wifulist2.data.Car
import com.example.wifulist2.data.CarsType
import com.example.wifulist2.data.carsCollection

@Composable
fun CarSpecsScreen(
    currentCarSpec : Car
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
                    text = currentCarSpec.name,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).background(MaterialTheme.colors.surface)) {
            Image(painter = painterResource(id = currentCarSpec.image),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.height(300.dp)
                    .padding(20.dp)
                )
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp)) {
                item { 
                    Text(
                        text = currentCarSpec.specs,
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}