package com.example.dresscode.ui.register

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConditionsCheckbox() {

    // état de la case à cocher
    var checked by remember {
        mutableStateOf(false)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = checked,
            onCheckedChange = {
                // mise à jour de l'état
                checked = it
            }
        )

        Text(
            text = "J'accepte les Conditions d'utilisation et la\nPolitique de confidentialité.",
            fontSize = 15.sp,
            lineHeight = 15.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}