package com.example.dresscode.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dresscode.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.vetement);
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        // image
        Image(
            painter = image,
            contentDescription = "Image de vêtement",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
            // opacity
            //alpha = 0.5F
        )

        // aligner les textes de façon vertical
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 40.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // TEXTE EN HAUT
            Text(
                text = "DressAi",
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Votre garde-robe intelligente réinventée avec style.",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .padding(start = 60.dp)
            )
        }
    }
}

