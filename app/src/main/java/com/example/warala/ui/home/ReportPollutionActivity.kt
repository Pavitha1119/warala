package com.example.warala.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityReportPollutionBinding
import com.example.warala.ui.event_activity.ThankYouVolunteerActivity

class ReportPollutionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReportPollutionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportPollutionBinding
            .inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Pollution level spinner
        val levels = listOf(
            "Pollution level",
            "Low",
            "Medium",
            "High",
            "Critical"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            levels
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        binding.spinnerPollutionLevel.adapter = adapter

        // ✅ Camera button
        binding.btnCamera.setOnClickListener {
            Toast.makeText(this, "Camera coming soon",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ REPORT button
        binding.btnReport.setOnClickListener {
            val location    = binding.etLocation
                .text.toString().trim()
            val title       = binding.etTitle
                .text.toString().trim()
            val level       = binding.spinnerPollutionLevel
                .selectedItem.toString()
            val description = binding.etDescription
                .text.toString().trim()

            when {
                location.isEmpty() ->
                    Toast.makeText(this,
                        "Select a location",
                        Toast.LENGTH_SHORT).show()
                title.isEmpty() ->
                    Toast.makeText(this,
                        "Add a title",
                        Toast.LENGTH_SHORT).show()
                level == "Pollution level" ->
                    Toast.makeText(this,
                        "Select pollution level",
                        Toast.LENGTH_SHORT).show()
                description.isEmpty() ->
                    Toast.makeText(this,
                        "Write a description",
                        Toast.LENGTH_SHORT).show()
                else -> {
                    Toast.makeText(this,
                        "Report submitted!",
                        Toast.LENGTH_SHORT).show()
                    // ✅ Volunteer button → Thank You Volunteer page
                    binding.btnReport.setOnClickListener {
                        startActivity(
                            Intent(this, ThankYouVolunteerActivity::class.java)
                        )
                        finish()
                    }
                }
            }
        }

        // ✅ REPORT ANONYMOUSLY button
        binding.btnReportAnonymously.setOnClickListener {
            Toast.makeText(this,
                "Anonymous report submitted!",
                Toast.LENGTH_SHORT).show()
            startActivity(
                Intent(this, HomeActivity::class.java)
            )
            finish()
        }

        // ✅ See other reports
        binding.tvSeeOtherReports.setOnClickListener {
            Toast.makeText(this, "Other reports",
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