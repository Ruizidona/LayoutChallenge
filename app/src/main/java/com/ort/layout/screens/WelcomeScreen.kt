package com.ort.layout.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.layout.R
import com.ort.layout.components.BackgroundDecoration

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundDecoration()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                    contentDescription = null,
                    modifier = Modifier.size(250.dp),
                    tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.welcome_title),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                lineHeight = 45.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = stringResource(id = R.string.welcome_subtitle),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(80.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(
                    onClick = onLoginClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                        .shadow(10.dp, RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.welcome_login_button),
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontSize = 18.sp)
                    )
                }

                TextButton(
                    onClick = onRegisterClick,
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.welcome_register_button),
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.Black, fontSize = 18.sp)
                    )
                }
            }
        }
    }
}
