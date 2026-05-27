package com.example.dresscode.ui.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
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
import com.example.dresscode.ui.components.SocialAuthButton
@Composable
fun RegisterScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.vetement)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // Image en arrière-plan
        Image(
            painter = image,
            contentDescription = "Image de vêtement",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.7F
        )

        // LazyColumn pour aligner les éléments verticalement
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(bottom = 30.dp)
        ) {

            // Titre principal
            item {
                Text(
                    text = "DressAi",
                    color = Color.Black,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Sous-titre
            item {
                Text(
                    text = "Créer un compte",
                    fontSize = 38.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            // Description
            item {
                Text(
                    text = "Rejoignez la révolution de la mode intelligente.",
                    fontSize = 15.sp,
                    lineHeight = 25.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }

            // Champ Nom Complet
            item {
                CustomInput("Nom Complet")
            }

            // Champ Mot de passe
            item {
                CustomInput("Mot de passe")
            }

            // Checkbox des conditions
            item {
                ConditionsCheckbox()
            }

            // Bouton S'inscrire
            item {
                PrimaryButton(
                    text = "S'inscrire",
                    onClick = { navController.navigate("home") }
                )
            }

            // Séparateur "ou continuer avec"
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                    HorizontalDivider(
                        modifier = Modifier.weight(1f),
                        thickness = 2.dp,
                        color = Color.Black.copy(alpha = 0.6f)
                    )
                }
            }

            // Boutons Google & Facebook
            item {
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

            // Lien vers la connexion
            item {
                Text(
                    text = "Vous avez déjà un compte? Se connecter",
                    fontSize = 17.sp,
                    lineHeight = 25.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }
        }
    }
}