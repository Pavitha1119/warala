package com.example.warala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.warala.ui.splash.SplashScreen01
import com.example.warala.ui.home.HomeScreen
import com.example.warala.ui.theme.WaralaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaralaTheme {
                var showSplash by remember { mutableStateOf(true) }

                if (showSplash) {
                    SplashScreen01(
                        onSplashFinished = { showSplash = false }
                    )
                } else {
                    HomeScreen()  // navigates here after splash
                }
            }
        }
    }
}