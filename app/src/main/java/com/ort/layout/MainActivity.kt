package com.ort.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.ort.layout.screens.LoginScreen
import com.ort.layout.screens.RegisterScreen
import com.ort.layout.screens.WelcomeScreen
import com.ort.layout.ui.theme.LayoutChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var currentScreen by remember { mutableStateOf("welcome") }

                    when (currentScreen) {
                        "welcome" -> WelcomeScreen(
                            onLoginClick = { currentScreen = "login" },
                            onRegisterClick = { currentScreen = "register" }
                        )
                        "login" -> LoginScreen(
                            onSignInClick = { /* Handle Sign In */ },
                            onCreateAccountClick = { currentScreen = "register" }
                        )
                        "register" -> RegisterScreen(
                            onSignUpClick = { /* Handle Sign Up */ },
                            onAlreadyHaveAccountClick = { currentScreen = "login" }
                        )
                    }
                }
            }
        }
    }
}
