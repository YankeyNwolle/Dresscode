package com.example.dresscode.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.dresscode.R
import com.example.dresscode.ui.components.SecondaryButton
import com.example.dresscode.ui.components.SocialAuthButton
import com.example.dresscode.ui.register.CustomInput

@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 40.dp, bottom = 40.dp),
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
                text = "Veuillez entrer vos coordonnées pour accéder à votre dressing.",
                fontSize = 19.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 30.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Champs de saisie
            CustomInput("Nom Complet")
            CustomInput("Mot de passe")

            Spacer(modifier = Modifier.height(25.dp))

            // Bouton de connexion
            SecondaryButton(
                text = "Se connecter",
                onClick = {
                    navController.navigate("home") // Redirection vers home après connexion
                },
                modifier = Modifier.padding(horizontal = 30.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Séparateur "ou continuer avec"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 1.dp,
                    color = Color.Gray.copy(alpha = 0.5f)
                )
                Text(
                    text = "ou continuer avec",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    thickness = 1.dp,
                    color = Color.Gray.copy(alpha = 0.5f)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Boutons Google & Facebook
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SocialAuthButton(
                    text = "Google",
                    icon = painterResource(id = R.drawable.google_icon),
                    modifier = Modifier.weight(1f),
                    onClick = { /* Action Google */ }
                )
                SocialAuthButton(
                    text = "Facebook",
                    icon = painterResource(id = R.drawable.facebook_icon),
                    modifier = Modifier.weight(1f),
                    onClick = { /* Action Facebook */ }
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Textes alignés verticalement
            Text(
                text = "Nouveau sur DressAi?",
                fontSize = 17.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Créer un compte",
                color = Color.Blue,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("register")
                }
            )
        }
    }
}
