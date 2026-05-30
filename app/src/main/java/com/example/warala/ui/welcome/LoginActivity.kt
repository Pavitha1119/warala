package com.example.warala.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.warala.R
import com.example.warala.databinding.ActivityLoginBinding
import com.example.warala.ui.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        auth.signOut()

        // ✅ Already logged in check
        if (auth.currentUser != null) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
            return
        }

        // ✅ Sign Up teal color
        val text = SpannableString("Don't have account? Sign Up")
        text.setSpan(
            ForegroundColorSpan(
                ContextCompat.getColor(this, R.color.teal_700)
            ),
            20, 27,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvSignUp.text = text

        // ✅ Sign Up click
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        // ✅ Forgot password
        binding.tvForgotPassword.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            if (email.isEmpty()) {
                Toast.makeText(this,
                    "Enter your email first",
                    Toast.LENGTH_SHORT).show()
            } else {
                auth.sendPasswordResetEmail(email)
                    .addOnSuccessListener {
                        Toast.makeText(this,
                            "Reset email sent!",
                            Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this,
                            "Error: ${it.message}",
                            Toast.LENGTH_SHORT).show()
                    }
            }
        }

        // ✅ LOGIN button
        binding.btnLogin.setOnClickListener {
            val email    = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            when {
                email.isEmpty() ->
                    Toast.makeText(this,
                        "Enter your email",
                        Toast.LENGTH_SHORT).show()
                password.isEmpty() ->
                    Toast.makeText(this,
                        "Enter your password",
                        Toast.LENGTH_SHORT).show()
                !android.util.Patterns.EMAIL_ADDRESS
                    .matcher(email).matches() ->
                    Toast.makeText(this,
                        "Enter a valid email",
                        Toast.LENGTH_SHORT).show()
                password.length < 6 ->
                    Toast.makeText(this,
                        "Password min 6 characters",
                        Toast.LENGTH_SHORT).show()
                else -> {
                    // ✅ Show loading message
                    Toast.makeText(this,
                        "Logging in...",
                        Toast.LENGTH_SHORT).show()

                    Log.d("Firebase", "Attempting login: $email")

                    // ✅ Firebase login
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener {
                            Log.d("Firebase", "Login success!")
                            Toast.makeText(this,
                                "Login successful!",
                                Toast.LENGTH_SHORT).show()
                            startActivity(
                                Intent(this, HomeActivity::class.java)
                            )
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Log.e("Firebase", "Login failed: $e")
                            Toast.makeText(this,
                                "Error: ${e.message}",
                                Toast.LENGTH_LONG).show()
                        }
                }
            }
        }

        // ✅ Social buttons
        binding.btnFacebook.setOnClickListener {
            Toast.makeText(this, "Facebook coming soon",
                Toast.LENGTH_SHORT).show()
        }
        binding.btnGoogle.setOnClickListener {
            Toast.makeText(this, "Google coming soon",
                Toast.LENGTH_SHORT).show()
        }
        binding.btnApple.setOnClickListener {
            Toast.makeText(this, "Apple coming soon",
                Toast.LENGTH_SHORT).show()
        }
    }
}