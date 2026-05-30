package com.example.warala.ui.event_activity


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityLogWasteBinding

class LogWasteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogWasteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogWasteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Waste type spinner
        val wasteTypes = listOf(
            "Waste type",
            "Plastic bottles",
            "Fishing nets",
            "Glass",
            "Metal cans",
            "Cigarette butts",
            "Food waste",
            "Other"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            wasteTypes
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        binding.spinnerWasteType.adapter = adapter

        // ✅ Upload photo click
        binding.cardUploadPhoto.setOnClickListener {
            Toast.makeText(this, "Camera coming soon",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ SUBMIT LOG button
        binding.btnSubmitLog.setOnClickListener {
            val wasteType = binding.spinnerWasteType
                .selectedItem.toString()
            val quantity  = binding.etQuantity
                .text.toString().trim()

            when {
                wasteType == "Waste type" ->
                    Toast.makeText(this,
                        "Select waste type",
                        Toast.LENGTH_SHORT).show()
                quantity.isEmpty() ->
                    Toast.makeText(this,
                        "Enter quantity",
                        Toast.LENGTH_SHORT).show()
                else -> {
                    Toast.makeText(this,
                        "Log submitted successfully!",
                        Toast.LENGTH_SHORT).show()
                    // ✅ Navigate to Thank You
                    startActivity(
                        Intent(this, ThankYouActivity::class.java)
                    )
                    finish()
                }
            }
        }

        // ✅ Submit new
        binding.tvSubmitNew.setOnClickListener {
            binding.spinnerWasteType.setSelection(0)
            binding.etQuantity.text.clear()
            binding.tvUploadPhoto.text = "Upload photo"
            Toast.makeText(this, "Form cleared",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Bottom navigation
        binding.navHome.setOnClickListener {
            startActivity(Intent(this, EventDetailActivity::class.java))
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