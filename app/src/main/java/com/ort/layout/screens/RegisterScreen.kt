package com.ort.layout.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.layout.R
import com.ort.layout.components.AuthTextField
import com.ort.layout.components.BackgroundDecoration
import com.ort.layout.components.SocialButton

@Composable
fun RegisterScreen(
    onSignUpClick: () -> Unit = {},
    onAlreadyHaveAccountClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundDecoration()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = stringResource(id = R.string.register_title),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = stringResource(id = R.string.register_subtitle),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(60.dp))

            AuthTextField(
                value = email, 
                onValueChange = { email = it }, 
                placeholder = stringResource(id = R.string.login_email_placeholder)
            )
            Spacer(modifier = Modifier.height(25.dp))
            AuthTextField(
                value = password, 
                onValueChange = { password = it }, 
                placeholder = stringResource(id = R.string.login_password_placeholder),
                isPassword = true
            )
            Spacer(modifier = Modifier.height(25.dp))
            AuthTextField(
                value = confirmPassword, 
                onValueChange = { confirmPassword = it }, 
                placeholder = stringResource(id = R.string.register_confirm_password),
                isPassword = true
            )

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = onSignUpClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .shadow(10.dp, RoundedCornerShape(10.dp)),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = stringResource(id = R.string.register_sign_up_button),
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontSize = 18.sp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            TextButton(onClick = onAlreadyHaveAccountClick) {
                Text(
                    text = stringResource(id = R.string.register_already_have_account),
                    style = MaterialTheme.typography.labelLarge.copy(color = Color.Black.copy(alpha = 0.8f))
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = stringResource(id = R.string.login_continue_with),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                SocialButton(icon = android.R.drawable.ic_menu_help)
                SocialButton(icon = android.R.drawable.ic_menu_share)
                SocialButton(icon = android.R.drawable.ic_menu_info_details)
            }
        }
    }
}
