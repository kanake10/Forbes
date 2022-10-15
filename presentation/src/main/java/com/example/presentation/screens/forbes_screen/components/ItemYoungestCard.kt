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
import com.example.domain.models.Youngest

@Composable
fun ItemYoungestCard(forbe: Youngest) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .width(190.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(190.dp),
                painter = rememberImagePainter(data = forbe.squareImage),
                contentDescription = " image",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = forbe.personName!!,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(6.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black,
                maxLines = 1
            )
        }
    }
}