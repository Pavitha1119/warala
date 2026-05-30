package com.example.warala.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Service cards
        binding.cardService1.setOnClickListener {
            Toast.makeText(this, "Pollution Reporting",
                Toast.LENGTH_SHORT).show()
        }
        binding.cardService2.setOnClickListener {
            Toast.makeText(this, "Clean-Up Event Tracker",
                Toast.LENGTH_SHORT).show()
        }
        binding.cardService3.setOnClickListener {
            Toast.makeText(this, "Waste Logging",
                Toast.LENGTH_SHORT).show()
        }
        binding.cardService4.setOnClickListener {
            Toast.makeText(this, "Marine Life Education",
                Toast.LENGTH_SHORT).show()
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

