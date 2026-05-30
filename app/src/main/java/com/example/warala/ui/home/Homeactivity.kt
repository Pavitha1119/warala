package com.example.warala.ui.home

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.warala.databinding.ActivityHomeBinding
import androidx.core.content.ContextCompat
import com.example.warala.R
import android.content.Intent
import com.example.warala.ui.event_activity.EventDetailActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Back button — new way
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding.drawerLayout
                            .isDrawerOpen(GravityCompat.END)
                    ) {
                        binding.drawerLayout
                            .closeDrawer(GravityCompat.END)
                    } else {
                        isEnabled = false
                        onBackPressedDispatcher.onBackPressed()
                    }
                }
            }
        )
        // ✅ Menu button — drawer open කරන්න
        binding.imgMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.END)
        }

        // ✅ Close drawer — back arrow
        binding.btnCloseDrawer.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.END)
        }

        // ✅ ABOUT US click
        binding.menuAboutUs.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.END)
            Toast.makeText(
                this, "About Us",
                Toast.LENGTH_SHORT
            ).show()
             startActivity(Intent(this, AboutActivity::class.java))
        }

        // ✅ FAQ click
        binding.menuFaq.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.END)
            Toast.makeText(
                this, "FAQ",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this, FaqActivity::class.java))
        }

        // ✅ CONTACT US click
        binding.menuContactUs.setOnClickListener {
            binding.drawerLayout.closeDrawer(GravityCompat.END)
            Toast.makeText(
                this, "Contact Us",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this, ContactActivity::class.java))
        }

        // ✅ Location spinner
        val locations = listOf(
            "Select location",
            "Colombo",
            "Hikkaduwa",
            "Galle",
            "Mirissa",
            "Trincomalee"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            locations
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        binding.spinnerLocation.adapter = adapter


        // ✅ Report Pollution button
        binding.btnReportPollution.setOnClickListener {
            startActivity(
                Intent(this, ReportPollutionActivity::class.java)
            )
        }

        // ✅ Cleanup cards
        binding.cardCleanup1.setOnClickListener {
            startActivity(Intent(this, EventDetailActivity::class.java))
        }
        binding.cardCleanup2.setOnClickListener {
            Toast.makeText(
                this, "EFL Beach Cleanup clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        // ✅ Event cards
        binding.cardEvent1.setOnClickListener {
            Toast.makeText(
                this, "Save Corals clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.cardEvent2.setOnClickListener {
            Toast.makeText(
                this, "Release Turtles clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        // ✅ Bottom navigation
        binding.navHome.setOnClickListener {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
        }
        binding.navCompass.setOnClickListener {
            startActivity(Intent(this, LearnActivity::class.java))
        }
        // ✅ navAdd button click
        binding.navAdd.setOnClickListener {
            startActivity(Intent(this, CreateEventActivity::class.java))
        }
        binding.navLocation.setOnClickListener {
            Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show()
        }
        binding.navProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
        // ✅ Heart toggle — gray ↔ teal
        var isLiked1 = false
        binding.imgHeart1.setOnClickListener {
            isLiked1 = !isLiked1
            if (isLiked1) {
                binding.imgHeart1.setColorFilter(
                    ContextCompat.getColor(this, R.color.teal_700)
                )
            } else {
                binding.imgHeart1.setColorFilter(
                    ContextCompat.getColor(this, R.color.gray_icon)
                )
            }
        }
    }
}