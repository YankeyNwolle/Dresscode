package com.example.dresscode.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        )

        // aligner les textes de façon vertical
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .verticalScroll(rememberScrollState()) // permet un scroll vertical
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
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .padding(horizontal = 30.dp) // ajoute une marge égale à gauche et à droite
            )

            Text(
                text = "L'art de s'habiller, simplifier par L'IA",
                color = Color.White,
                fontSize = 35.sp,
                lineHeight = 42.sp, // hauteur entre les lignes
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 300.dp)
                    .padding(start = 60.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // boutons d'authentification

            PrimaryButton(
                text = "S'inscrire",
                onClick = { navController.navigate("register")}
            )

            Spacer(modifier = Modifier.height(20.dp))

            SecondaryButton(
                text = "Se connecter",
                onClick = {
                    navController.navigate("login")}
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "En continuant, vous acceptez nos Conditions d'utilisation.",
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .padding(horizontal = 30.dp)
            )

        }
    }
}

