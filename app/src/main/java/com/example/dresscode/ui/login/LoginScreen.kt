package com.example.dresscode.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dresscode.ui.components.SecondaryButton
import com.example.dresscode.ui.register.CustomInput

@Composable
fun LoginScreen (navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

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
                color = Color.Black,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Bon retour",
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Veuillez entrer vos coordonnées pour accéder à votre dressing. ",
                fontSize = 19.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp)
            )

            // Champ Nom Complet

            CustomInput("Nom Complet")


            // Champ Mot de passe

            CustomInput("Mot de passe")

            Spacer(modifier = Modifier.height(20.dp))

            //  Bouton de connexion
            SecondaryButton(
                text = "Se connecter",
                onClick = {
                    navController.navigate("login")}
            )


        }
    }
}