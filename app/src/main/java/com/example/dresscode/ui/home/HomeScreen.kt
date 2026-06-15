package com.example.dresscode.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dresscode.R
import com.example.dresscode.ui.components.PrimaryButton
import com.example.dresscode.ui.components.SecondaryButton

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.vetement),
            contentDescription = "Image de vetement",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Fond sombre simple
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.46f))
        )

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(450)) +
                slideInVertically(
                    animationSpec = tween(450),
                    initialOffsetY = { it / 5 }
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 40.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // App name & tagline (original)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "DressAi",
                        color = Color.White,
                        fontSize = 44.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Votre garde-robe intelligente réinventée avec style.",
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(160.dp))

                // supposition des boutons
                Column {
                    PrimaryButton(
                        text = "S'inscrire",
                        onClick = { navController.navigate("register") }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    SecondaryButton(
                        text = "Se connecter",
                        onClick = { navController.navigate("login") }
                    )
                }

                // text legal
                Text(
                    text = "En continuant, vous acceptez nos Conditions d'utilisation.",
                    color = Color.White.copy(alpha = 0.82f),
                    fontSize = 13.sp,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(top = 20.dp, start = 12.dp, end = 12.dp)
                )
            }
        }
    }
}
