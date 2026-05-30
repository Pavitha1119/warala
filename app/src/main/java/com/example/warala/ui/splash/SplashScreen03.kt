package com.example.warala.ui.splash

import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.warala.R

@Composable
fun SplashScreen03(onGetStarted: () -> Unit) {

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
                    .aspectRatio(0.72f)
                    .clip(RoundedCornerShape(32.dp))
                    .background(Color(0xFFB8DDE8)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(24.dp)
                ) {

                    // Title text
                    Text(
                        text = "REPORT MARINE\nPOLLUTION",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.Serif,
                        color = Color(0xFF1E6F8E),
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Description text
                    Text(
                        text = "EASILY REPORT PLASTIC WASTE, OIL\nSPILLS, AND MARINE THREATS WITH\nPHOTOS AND LOCATION.",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF1E6F8E),
                        textAlign = TextAlign.Center,
                        letterSpacing = 1.sp,
                        lineHeight = 18.sp
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Illustration image
                    Image(
                        painter = painterResource(id = R.drawable.splash03_report_illustration),
                        contentDescription = "Report Illustration",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Dot indicators — dot 2 active
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(4) { index ->
                    Box(
                        modifier = Modifier
                            .size(if (index == 1) 12.dp else 10.dp)  // dot 2 active
                            .clip(CircleShape)
                            .background(
                                if (index == 1) Color(0xFF1E6F8E)
                                else Color(0xFFB0BEC5)
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
                    containerColor = Color(0xFF1E6F8E)
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

