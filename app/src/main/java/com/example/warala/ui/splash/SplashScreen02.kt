package com.example.warala.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontFamily
import com.example.warala.R
import androidx.compose.ui.text.font.Font

val CarattereFont = FontFamily(
    Font(R.font.carattere)
)

// Colors
val LightBlueCard  = Color(0xFFB8DDE8)   // card background
val DarkTealButton = Color(0xFF1E6F8E)   // GET STARTED button
val DotActive      = Color(0xFF1E6F8E)   // first dot (active)
val DotInactive    = Color(0xFFB0BEC5)   // remaining dots

@Composable
fun SplashScreen02(onGetStarted: () -> Unit) {

    // Gray outer background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEEEEEE)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            // Light blue rounded card
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.82f)
                    .aspectRatio(0.72f)              // portrait card ratio
                    .clip(RoundedCornerShape(32.dp))
                    .background(LightBlueCard),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    //  White circle with mermaid logo
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_waralalogo),
                            contentDescription = "Warala Logo",
                            modifier = Modifier
                                .size(90.dp)
                                .padding(6.dp),
                            contentScale = ContentScale.Fit
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    //  WARALA title
                    Text(
                        text = "WARALA",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        color = Color.White,
                        letterSpacing = 8.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    //  Italic tagline "Protect the blue..."
                    Text(
                        text = "Protect the blue...",
                        fontSize = 36.sp,
                        fontStyle = FontStyle.Italic,
                        fontFamily = CarattereFont,
                        color = DarkTealButton,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Dot indicators (4 dots, first one active)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(4) { index ->
                    Box(
                        modifier = Modifier
                            .size(if (index == 0) 12.dp else 10.dp)   // active dot bigger
                            .clip(CircleShape)
                            .background(
                                if (index == 0) DotActive else DotInactive
                            )
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // GET STARTED button
            Button(
                onClick = { onGetStarted() },
                modifier = Modifier
                    .fillMaxWidth(0.72f)
                    .height(50.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkTealButton
                )
            ) {
                Text(
                    text = "GET STARTED",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    letterSpacing = 3.sp
                )
            }
        }
    }
}