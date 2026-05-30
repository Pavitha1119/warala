package com.example.warala.ui.event_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityThankYouVolunteerBinding
import com.example.warala.ui.home.HomeActivity

class ThankYouVolunteerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThankYouVolunteerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThankYouVolunteerBinding
            .inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Collect badge click
        binding.cardBadge.setOnClickListener {
            Toast.makeText(this, "Badge collected!",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ SEE HISTORY button
        binding.btnSeeHistory.setOnClickListener {
            Toast.makeText(this, "History coming soon",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ BACK TO HOME button
        binding.btnBackToHome.setOnClickListener {
            startActivity(
                Intent(this, HomeActivity::class.java)
            )
            finish()
        }
    }
}