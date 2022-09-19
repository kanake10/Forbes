package com.example.presentation.screens.forbes_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.domain.models.AllForbes
import com.example.domain.models.Female
import com.example.domain.models.Industry

@Composable
fun ItemIndustryCard(forbe: Industry) {
    Card(
        modifier = Modifier
            .size(120.dp, 250.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(8.dp)),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            val image: Painter = rememberImagePainter(data = forbe.squareImage)

            Image(
                modifier = Modifier
                    .height(120.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = image,
                alignment = Alignment.Center,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Text(
                text = forbe.personName!!,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
                maxLines = 1
            )

        }

    }
}