package com.example.dresscode.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dresscode.ui.theme.Transparent30

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        shape = RoundedCornerShape(50.dp), // permet d'arrondir les bords
        border = BorderStroke(1.dp, Color.White),
        // Ajout d'une couleur transparent en background du bouton
        colors = ButtonDefaults.buttonColors(containerColor = Transparent30)
    ) {

        Text(
            text = text,
            color = Color.White,
            fontSize = 25.sp
        )
    }
}