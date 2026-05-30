package com.example.warala.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        db   = FirebaseFirestore.getInstance()

        // ✅ Load user data from Firestore
        val userId = auth.currentUser?.uid
        userId?.let {
            db.collection("users")
                .document(it)
                .get()
                .addOnSuccessListener { doc ->
                    val name = doc.getString("name") ?: "User"
                    binding.tvName.text = name.uppercase()
                }
        }

        // ✅ Edit profile
        binding.tvEditProfile.setOnClickListener {
            Toast.makeText(this, "Edit profile coming soon",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Share profile
        binding.tvShareProfile.setOnClickListener {
            Toast.makeText(this, "Share profile coming soon",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Earned Badges
        binding.cardEarnedBadges.setOnClickListener {
            Toast.makeText(this, "Earned Badges",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Event Log
        binding.cardEventLog.setOnClickListener {
            Toast.makeText(this, "Event Log",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Report History
        binding.cardReportHistory.setOnClickListener {
            Toast.makeText(this, "Report History",
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
            // already here
        }
    }
}