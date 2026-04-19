package com.ort.layout.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SocialButton(icon: Int) {
    IconButton(
        onClick = { },
        modifier = Modifier
            .size(55.dp)
            .background(Color(0xFFECECEC), RoundedCornerShape(10.dp))
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
    }
}
