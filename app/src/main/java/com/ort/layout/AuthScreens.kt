package com.ort.layout

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ort.layout.ui.theme.LayoutChallengeTheme

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
            // Illustration Placeholder
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
                text = "Discover Your\nDream Job here",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                lineHeight = 45.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Explore all the existing job roles based on your interest and study major",
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
                        text = "Login",
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
                        text = "Register",
                        style = MaterialTheme.typography.titleLarge.copy(color = Color.Black, fontSize = 18.sp)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    onSignInClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {}
) {
    // Definimos el estado para los campos
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                text = "Login here",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Welcome back you've\nbeen missed!",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(70.dp))

            AuthTextField(
                value = email, 
                onValueChange = { email = it }, 
                placeholder = "Email"
            )
            Spacer(modifier = Modifier.height(25.dp))
            AuthTextField(
                value = password, 
                onValueChange = { password = it }, 
                placeholder = "Password",
                isPassword = true
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Forgot your password?",
                modifier = Modifier.align(Alignment.End),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = onSignInClick,
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
                    text = "Sign in",
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontSize = 18.sp)
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            TextButton(onClick = onCreateAccountClick) {
                Text(
                    text = "Create new account",
                    style = MaterialTheme.typography.labelLarge.copy(color = Color.Black.copy(alpha = 0.8f))
                )
            }

            Spacer(modifier = Modifier.height(70.dp))

            Text(
                text = "Or continue with",
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

@Composable
fun RegisterScreen(
    onSignUpClick: () -> Unit = {},
    onAlreadyHaveAccountClick: () -> Unit = {}
) {
    // Definimos el estado para los campos
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
                text = "Create Account",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Create an account so you can explore all the existing jobs",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(60.dp))

            AuthTextField(
                value = email, 
                onValueChange = { email = it }, 
                placeholder = "Email"
            )
            Spacer(modifier = Modifier.height(25.dp))
            AuthTextField(
                value = password, 
                onValueChange = { password = it }, 
                placeholder = "Password",
                isPassword = true
            )
            Spacer(modifier = Modifier.height(25.dp))
            AuthTextField(
                value = confirmPassword, 
                onValueChange = { confirmPassword = it }, 
                placeholder = "Confirm Password",
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
                    text = "Sign up",
                    style = MaterialTheme.typography.titleLarge.copy(color = Color.White, fontSize = 18.sp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            TextButton(onClick = onAlreadyHaveAccountClick) {
                Text(
                    text = "Already have an account",
                    style = MaterialTheme.typography.labelLarge.copy(color = Color.Black.copy(alpha = 0.8f))
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Or continue with",
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

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { 
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray)
            ) 
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
        ),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

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

@Preview(showBackground = true)
@Composable
fun WelcomePreview() {
    LayoutChallengeTheme {
        WelcomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LayoutChallengeTheme {
        LoginScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    LayoutChallengeTheme {
        RegisterScreen()
    }
}
