package com.example.warala.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ SUBMIT button
        binding.btnSubmit.setOnClickListener {
            val email   = binding.etEmail.text.toString().trim()
            val title   = binding.etTitle.text.toString().trim()
            val message = binding.etMessage.text.toString().trim()

            when {
                email.isEmpty() ->
                    Toast.makeText(this, "Enter your email",
                        Toast.LENGTH_SHORT).show()
                title.isEmpty() ->
                    Toast.makeText(this, "Add a title",
                        Toast.LENGTH_SHORT).show()
                message.isEmpty() ->
                    Toast.makeText(this, "Write a message",
                        Toast.LENGTH_SHORT).show()
                !android.util.Patterns.EMAIL_ADDRESS
                    .matcher(email).matches() ->
                    Toast.makeText(this, "Enter a valid email",
                        Toast.LENGTH_SHORT).show()
                else -> {
                    Toast.makeText(this,
                        "Message sent successfully!",
                        Toast.LENGTH_SHORT).show()
                    // ✅ Clear fields
                    binding.etEmail.text.clear()
                    binding.etTitle.text.clear()
                    binding.etMessage.text.clear()
                }
            }
        }

        // ✅ Bottom navigation
        binding.navHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        binding.navCompass.setOnClickListener {
            Toast.makeText(this, "Explore",
                Toast.LENGTH_SHORT).show()
        }
        binding.navAdd.setOnClickListener {
            Toast.makeText(this, "Add",
                Toast.LENGTH_SHORT).show()
        }
        binding.navLocation.setOnClickListener {
            Toast.makeText(this, "Location",
                Toast.LENGTH_SHORT).show()
        }
        binding.navProfile.setOnClickListener {
            Toast.makeText(this, "Profile",
                Toast.LENGTH_SHORT).show()
        }
    }
}
