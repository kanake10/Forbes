package com.example.presentation.screens.forbes_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.presentation.screens.forbes_screen.components.*
import com.example.presentation.viewmodels.*

@Composable
fun ForbesScreen(
    navController: NavHostController,
    allViewModel: AllForbesViewModel = hiltViewModel(),
    femalesViewModel: FemalesViewModel = hiltViewModel(),
    industryViewModel: IndustryViewModel = hiltViewModel(),
    malesViewModel: MalesViewModel = hiltViewModel(),
    oldestViewModel: OldestViewModel = hiltViewModel(),
    youngestViewModel: YoungestViewModel = hiltViewModel()
) {
    val allforbesState = allViewModel.state.value
    val femalesState = femalesViewModel.state.value
    val industryState = industryViewModel.state.value
    val malesState = malesViewModel.state.value
    val oldestState = oldestViewModel.state.value
    val youngestState = youngestViewModel.state.value



    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "All forbes",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(270.dp)) {
                items(allforbesState.allForbes) { forbes ->
                    ItemForbesCard(forbe = forbes)
                }
            }
            Text(
                text = "Females forbes",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(270.dp)) {
                items(femalesState.female) { forbes ->
                    ItemFemalesCard(forbe = forbes)
                }
            }
            Text(
                text = "Males forbes",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(270.dp)) {
                items(malesState.males) { forbes ->
                    ItemMalesCard(forbe = forbes)
                }
            }
            Text(
                text = "Industry forbes",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(270.dp)) {
                items(industryState.industry) { forbes ->
                    ItemIndustryCard(forbe = forbes)
                }
            }
            Text(
                text = "Oldest forbes",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(270.dp)) {
                items(oldestState.oldest) { forbes ->
                    ItemOldestCard(forbe = forbes)
                }
            }
            Text(
                text = "Youngest forbes",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                color = Color.White
            )
            LazyRow(modifier = Modifier.height(270.dp)) {
                items(youngestState.youngest) { forbes ->
                    ItemYoungestCard(forbe = forbes)
                }
            }
        }


        if (allforbesState.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        if (allforbesState.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(text = allforbesState.error, modifier = Modifier.align(Alignment.Center))
            }
        }
    }

}