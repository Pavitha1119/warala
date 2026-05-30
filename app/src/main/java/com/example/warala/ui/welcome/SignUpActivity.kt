package com.example.warala.ui.welcome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Initialize Firebase
        auth = FirebaseAuth.getInstance()
        db   = FirebaseFirestore.getInstance()

        Log.d("Firebase", "Auth: $auth")

        binding.btnSignUp.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
            val name     = binding.etFullName.text.toString().trim()
            val email    = binding.etEmail.text.toString().trim()
            val phone    = binding.etPhone.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirm  = binding.etConfirmPassword.text.toString().trim()

            when {
                name.isEmpty() ->
                    Toast.makeText(this, "Enter your name",
                        Toast.LENGTH_SHORT).show()
                email.isEmpty() ->
                    Toast.makeText(this, "Enter your email",
                        Toast.LENGTH_SHORT).show()
                password != confirm ->
                    Toast.makeText(this, "Passwords don't match",
                        Toast.LENGTH_SHORT).show()
                password.length < 6 ->
                    Toast.makeText(this, "Password min 6 characters",
                        Toast.LENGTH_SHORT).show()
                else -> {
                    // ✅ Show loading
                    Toast.makeText(this, "Creating account...",
                        Toast.LENGTH_SHORT).show()

                    Log.d("Firebase", "Attempting signup: $email")

                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnSuccessListener {
                            Log.d("Firebase", "Signup success!")

                            val userId = auth.currentUser?.uid
                                val user = hashMapOf(
                                    "name"  to name,
                                    "email" to email,
                                    "phone" to phone
                                )
                            userId?.let {
                                db.collection("users")
                                    .document(it)
                                    .set(user)
                                    .addOnSuccessListener {
                                        Log.d("Firebase", "Firestore saved!")
                                    }
                                    .addOnFailureListener { e ->
                                        Log.e("Firebase", "Firestore error: $e")
                                    }
                            }
                            Toast.makeText(this,
                                "Account created!",
                                Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,
                                LoginActivity::class.java))
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Log.e("Firebase", "Signup failed: $e")
                            Toast.makeText(this,
                                "Error: ${e.message}",
                                Toast.LENGTH_LONG).show()
                        }
                }
            }
        }
    }
}
