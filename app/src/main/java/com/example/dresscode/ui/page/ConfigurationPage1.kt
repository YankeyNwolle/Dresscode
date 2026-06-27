package com.example.dresscode.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.dresscode.ui.home.AuthViewModel

@Composable
fun ConfigurationPage1(navController: NavHostController,
                       modifier: Modifier = Modifier,
                       authViewModel: AuthViewModel = viewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 24.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.Black)) {
                        append("Dress")
                    }
                    withStyle(SpanStyle(color = Color(0xFFA3E4D7))) {
                        append("Ai")
                    }
                },
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(SpanStyle(color = Color(0xFF75777E))) {
                        append("Étape 1 sur 3")
                    }
                },
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
