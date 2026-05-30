package com.example.warala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.warala.ui.splash.SplashScreen01
import com.example.warala.ui.splash.SplashScreen02
import com.example.warala.ui.splash.SplashScreen03
import com.example.warala.ui.splash.SplashScreen04
import com.example.warala.ui.splash.SplashScreen05
import com.example.warala.ui.welcome.SplashScreen06
import com.example.warala.ui.welcome.LoginActivity
import com.example.warala.ui.welcome.SignUpActivity
import android.content.Intent
import com.example.warala.ui.theme.WaralaTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaralaTheme {
                var showSplash by remember { mutableStateOf (0) }

                when (showSplash) {
                    0 -> SplashScreen01(onSplashFinished = { showSplash = 1 })
                    1 -> SplashScreen02(onGetStarted = { showSplash = 2 })
                    2 -> SplashScreen03(onGetStarted = { showSplash = 3 })
                    3 -> SplashScreen04(onGetStarted = { showSplash = 4 })
                    4 -> SplashScreen05(onGetStarted = { showSplash = 5 })

                    5 -> SplashScreen06(
                        onLoginClick = {
                            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                        },
                        onSignUpClick = {
                            startActivity(Intent(this@MainActivity, SignUpActivity::class.java))
                        }
                    )
                        }

                }
        }


            }
        }
