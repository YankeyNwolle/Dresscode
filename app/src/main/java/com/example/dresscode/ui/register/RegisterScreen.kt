package com.example.dresscode.ui.register

import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch
import androidx.compose.ui.res.stringResource
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dresscode.R
import com.example.dresscode.ui.components.PrimaryButton
import com.example.dresscode.ui.components.SocialAuthButton
import com.example.dresscode.ui.home.AuthState
import com.example.dresscode.ui.home.AuthViewModel

@Composable
fun RegisterScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = viewModel()
) {
    var visible by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    
    val authState by authViewModel.authState.collectAsState()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val credentialManager = CredentialManager.create(context)
    val webClientId = stringResource(id = R.string.default_web_client_id)

    LaunchedEffect(Unit) {
        visible = true
    }

    LaunchedEffect(authState) {
        if (authState is AuthState.Authenticated) {
            navController.navigate("home") {
                popUpTo("register") { inclusive = true }
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(420)) +
                slideInVertically(
                    animationSpec = tween(420),
                    initialOffsetY = { it / 6 }
                )
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(top = 36.dp, bottom = 32.dp)
            ) {
                item {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(SpanStyle(color = Color.Black)) {
                                append("Dress")
                            }
                            withStyle(SpanStyle(color = Color(0xFFA3E4D7))) {
                                append("Ai")
                            }
                        },
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(30.dp))
                }

                item {
                    Text(
                        text = "Creer un compte",
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }

                item {
                    Text(
                        text = "Rejoignez la mode intelligente avec un dressing pense pour vous.",
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        color = Color.Black.copy(alpha = 0.68f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 10.dp, start = 30.dp, end = 30.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(26.dp))
                }

                item {
                    CustomInput(
                        value = email,
                        onValueChange = { email = it },
                        label = "Adresse email",
                        keyboardType = KeyboardType.Email
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {
                    CustomInput(
                        value = password,
                        onValueChange = { password = it },
                        label = "Mot de passe",
                        isPassword = true,
                        keyboardType = KeyboardType.Password
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {
                    ConditionsCheckbox(
                        modifier = Modifier.padding(horizontal = 6.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item {
                    if (authState is AuthState.Loading) {
                        CircularProgressIndicator(color = Color(0xFFA3E4D7))
                    } else {
                        PrimaryButton(
                            text = "S'inscrire",
                            onClick = { authViewModel.signUp(email, password) },
                            modifier = Modifier.padding(horizontal = 24.dp)
                        )
                    }
                }
                
                if (authState is AuthState.Error) {
                    item {
                        Text(
                            text = (authState as AuthState.Error).message,
                            color = Color.Red,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(30.dp))
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            thickness = 1.dp,
                            color = Color.Black.copy(alpha = 0.12f)
                        )
                        Text(
                            text = "ou continuer avec",
                            fontSize = 14.sp,
                            color = Color.Black.copy(alpha = 0.56f),
                            modifier = Modifier.padding(horizontal = 12.dp)
                        )
                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            thickness = 1.dp,
                            color = Color.Black.copy(alpha = 0.12f)
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(22.dp))
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        SocialAuthButton(
                            text = "Google",
                            icon = painterResource(id = R.drawable.google_icon),
                            modifier = Modifier.weight(1f),
                            onClick = {
                                scope.launch {
                                    val googleIdOption = GetGoogleIdOption.Builder()
                                        .setFilterByAuthorizedAccounts(false)
                                        .setServerClientId(webClientId)
                                        .build()

                                    val request = GetCredentialRequest.Builder()
                                        .addCredentialOption(googleIdOption)
                                        .build()

                                    try {
                                        val result = credentialManager.getCredential(
                                            context = context,
                                            request = request
                                        )
                                        val credential = result.credential
                                        if (credential is GoogleIdTokenCredential) {
                                            val firebaseCredential = GoogleAuthProvider.getCredential(credential.idToken, null)
                                            authViewModel.signInWithGoogle(firebaseCredential)
                                        }
                                    } catch (e: Exception) {
                                        // Gérer l'erreur si nécessaire
                                    }
                                }
                            }
                        )
                        SocialAuthButton(
                            text = "Facebook",
                            icon = painterResource(id = R.drawable.facebook_icon),
                            modifier = Modifier.weight(1f),
                            onClick = { }
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(32.dp))
                }

                item {
                    Text(
                        text = "Vous avez deja un compte ?",
                        fontSize = 15.sp,
                        lineHeight = 21.sp,
                        color = Color.Black.copy(alpha = 0.72f),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 30.dp)
                    )

                    Text(
                        text = "Se connecter",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navController.navigate("login")
                        }
                    )
                }
            }
        }
    }
}
