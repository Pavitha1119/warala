package com.example.warala.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityLearnBinding

class LearnActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLearnBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLearnBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Admire the sea
        binding.btnAdmireSea.setOnClickListener {
            Toast.makeText(this, "Admire the sea!",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Category cards
        binding.cardMarineSpecies.setOnClickListener {
            Toast.makeText(this, "Marine Species",
                Toast.LENGTH_SHORT).show()
        }
        binding.cardCoralReefs.setOnClickListener {
            Toast.makeText(this, "Coral Reefs",
                Toast.LENGTH_SHORT).show()
        }
        binding.cardOcean.setOnClickListener {
            Toast.makeText(this, "Ocean",
                Toast.LENGTH_SHORT).show()
        }
        binding.cardEndangered.setOnClickListener {
            Toast.makeText(this, "Endangered",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Did You Know
        binding.cardDidYouKnow.setOnClickListener {
            Toast.makeText(this, "Learn more facts!",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Plastic Footprint
        binding.cardPlasticFootprint.setOnClickListener {
            Toast.makeText(this, "Test your plastic footprint",
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