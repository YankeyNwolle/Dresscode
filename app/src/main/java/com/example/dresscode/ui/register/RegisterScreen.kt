package com.example.dresscode.ui.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import com.example.dresscode.ui.components.SocialAuthButton

@Composable
fun RegisterScreen (navController: NavHostController, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.vetement);
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // image en arrière plan

        Image(
            painter = image,
            contentDescription = "Image de vêtement",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.7F // l'opacité
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
                color = Color.Black,
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Créer un compte",
                fontSize = 38.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Rejoignez la révolution de la mode intelligente.",
                fontSize = 15.sp,
                lineHeight = 25.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 30.dp)
                    .padding(horizontal = 5.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            CustomInput("Nom Complet")

            Spacer(modifier = Modifier.height(10.dp))
            CustomInput("Mot de passe : ")

            Spacer(modifier = Modifier.height(30.dp))

            // composable pour le checkbox
            ConditionsCheckbox()

            Spacer(modifier = Modifier.height(30.dp))

            PrimaryButton(
                text = "S'inscrire",
                onClick = { navController.navigate("register")}
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // ajout de traits hortizonal à gauche du text
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 2.dp,
                    color = Color.Black.copy(alpha = 0.6f)
                )

                Text(
                    text = "ou continuer avec",
                    fontSize = 15.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                // ajout de traits hortizonal à droite du text
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 2.dp,
                    color = Color.Black.copy(alpha = 0.6f)
                )

            }

            Spacer(modifier = Modifier.height(30.dp))

            // ajout de bouton d'authentification

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SocialAuthButton(
                    text = "Google",
                    icon = painterResource(id = R.drawable.google_icon),
                    modifier = Modifier.weight(1f),
                    onClick = { }
                )

                SocialAuthButton(
                    text = "Facebook",
                    icon = painterResource(id = R.drawable.facebook_icon),
                    modifier = Modifier.weight(1f),
                    onClick = { }
                )
            }


        }
    }

}