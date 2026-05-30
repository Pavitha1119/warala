package com.example.warala.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.warala.R
import androidx.compose.ui.graphics.painter.ColorPainter

@Composable
fun SplashScreen06(
    onLoginClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = ColorPainter(Color(0xFF7DD4CF)),
            contentDescription = "Ocean Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // ✅ Curve overlay image
        Image(
            painter = painterResource(id = R.drawable.ic_wales_and_sea),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.9f
        )

        // ✅ Bottom white card with buttons
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(
                    start = 40.dp,
                    end = 40.dp,
                    top = 30.dp,
                    bottom = 60.dp
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // ✅ LOG IN button
                Button(
                    onClick = { onLoginClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    elevation = ButtonDefaults.buttonElevation(4.dp)
                ) {
                    Text(
                        text = "LOG IN",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E6F8E),
                        letterSpacing = 2.sp
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                // ✅ SIGN UP button
                OutlinedButton(
                    onClick = { onSignUpClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = androidx.compose.foundation.BorderStroke(
                        1.5.dp, Color(0xFF1E6F8E)
                    ),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color(0xFF1E6F8E)
                    )
                ) {
                    Text(
                        text = "SIGN UP",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E6F8E),
                        letterSpacing = 2.sp
                    )
                }
            }
        }

        // ✅ Top left logo + text
        Row(
            modifier = Modifier
                .padding(start = 24.dp, top = 56.dp)
                .align(Alignment.TopStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // White circle logo
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_waralalogo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(4.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // WARALA + tagline
            Column {
                Text(
                    text = "WARALA",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    letterSpacing = 4.sp
                )
                Text(
                    text = "Protect the blue...",
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.White
                )
            }
        }
    }
}