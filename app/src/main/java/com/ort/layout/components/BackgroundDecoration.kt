package com.ort.layout.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun BackgroundDecoration() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        // Top right decoration
        drawCircle(
            color = Color(0xFFF1F4FF),
            radius = width * 0.4f,
            center = Offset(width * 0.9f, height * 0.1f)
        )

        // Bottom left decoration
        val path = Path().apply {
            moveTo(0f, height * 0.8f)
            quadraticTo(
                width * 0.2f, height * 0.85f,
                width * 0.4f, height
            )
            lineTo(0f, height)
            close()
        }
        drawPath(path, color = Color(0xFFF1F4FF))
    }
}
