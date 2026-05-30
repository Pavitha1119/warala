package com.example.warala.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityFaqBinding

class FaqActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Email us click
        binding.cardEmailUs.setOnClickListener {
            Toast.makeText(this, "Email: support@warala.com",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Report click
        binding.cardReport.setOnClickListener {
            Toast.makeText(this, "Report a problem",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Terms click
        binding.cardTerms.setOnClickListener {
            Toast.makeText(this, "Terms & Conditions",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ FAQ cards — toggle answer show/hide
        binding.cardFaq1.setOnClickListener {
            toggleAnswer(binding.tvAnswer1)
        }
        binding.cardFaq2.setOnClickListener {
            toggleAnswer(binding.tvAnswer2)
        }
        binding.cardFaq3.setOnClickListener {
            toggleAnswer(binding.tvAnswer3)
        }

        // ✅ Bottom navigation
        binding.navHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        binding.navCompass.setOnClickListener {
            Toast.makeText(this, "Explore", Toast.LENGTH_SHORT).show()
        }
        binding.navAdd.setOnClickListener {
            Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
        }
        binding.navLocation.setOnClickListener {
            Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show()
        }
        binding.navProfile.setOnClickListener {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
        }
    }

    // ✅ Toggle answer visibility
    private fun toggleAnswer(answerView: View) {
        if (answerView.visibility == View.GONE) {
            answerView.visibility = View.VISIBLE
        } else {
            answerView.visibility = View.GONE
        }
    }
}

