package com.example.warala.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.warala.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen01(onSplashFinished: () -> Unit) {

    LaunchedEffect(Unit) {
        delay(4500L)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1E6F8E)),      //  exact teal background color
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-30).dp)            //  shift slightly above center
        ) {

            //  White circle with mermaid logo inside
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(100.dp)                // circle size
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_waralalogo),
                    contentDescription = "Warala Logo",
                    modifier = Modifier
                        .size(100.dp)            // logo fills most of circle
                        .padding(4.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            // ✅ WARALA — wide letter spacing, white, lightweight serif look
            Text(
                text = "WARALA",
                fontSize = 32.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                letterSpacing = 10.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}