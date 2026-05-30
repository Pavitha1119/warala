package com.example.warala.ui.home

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityCreateEventBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Calendar

class CreateEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateEventBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db   = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

        // ✅ Event type spinner
        val eventTypes = listOf(
            "Event type",
            "Beach Cleanup",
            "Marine Survey",
            "Coral Planting",
            "Awareness Session",
            "Waste Collection",
            "Other"
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            eventTypes
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        binding.spinnerEventType.adapter = adapter

        // ✅ Time picker
        binding.etTime.setOnClickListener {
            val cal = Calendar.getInstance()
            TimePickerDialog(this, { _, hour, minute ->
                val amPm = if (hour < 12) "AM" else "PM"
                val h = if (hour > 12) hour - 12 else hour
                binding.etTime.setText(
                    String.format("%02d:%02d %s", h, minute, amPm)
                )
            },
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                false).show()
        }

        // ✅ Date picker
        binding.etDate.setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(this, { _, year, month, day ->
                binding.etDate.setText(
                    String.format("%02d/%02d/%d", day, month + 1, year)
                )
            },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        // ✅ Upload photo
        binding.cardUploadPhoto.setOnClickListener {
            Toast.makeText(this, "Camera coming soon",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ CREATE EVENT button
        binding.btnCreateEvent.setOnClickListener {
            val eventType   = binding.spinnerEventType
                .selectedItem.toString()
            val title       = binding.etTitle
                .text.toString().trim()
            val time        = binding.etTime
                .text.toString().trim()
            val date        = binding.etDate
                .text.toString().trim()
            val org         = binding.etOrganization
                .text.toString().trim()
            val description = binding.etDescription
                .text.toString().trim()

            when {
                eventType == "Event type" ->
                    Toast.makeText(this, "Select event type",
                        Toast.LENGTH_SHORT).show()
                title.isEmpty() ->
                    Toast.makeText(this, "Add a title",
                        Toast.LENGTH_SHORT).show()
                time.isEmpty() ->
                    Toast.makeText(this, "Add time",
                        Toast.LENGTH_SHORT).show()
                date.isEmpty() ->
                    Toast.makeText(this, "Add date",
                        Toast.LENGTH_SHORT).show()
                org.isEmpty() ->
                    Toast.makeText(this, "Add organization",
                        Toast.LENGTH_SHORT).show()
                else -> {
                    // ✅ Save to Firestore
                    val event = hashMapOf(
                        "type"         to eventType,
                        "title"        to title,
                        "time"         to time,
                        "date"         to date,
                        "organization" to org,
                        "description"  to description,
                        "createdBy"    to (auth.currentUser?.uid ?: "")
                    )
                    db.collection("events")
                        .add(event)
                        .addOnSuccessListener {
                            Toast.makeText(this,
                                "Event created!",
                                Toast.LENGTH_SHORT).show()
                            startActivity(
                                Intent(this, HomeActivity::class.java)
                            )
                            finish()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this,
                                "Error: ${e.message}",
                                Toast.LENGTH_LONG).show()
                        }
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
            // already here
        }
        binding.navLocation.setOnClickListener {
            Toast.makeText(this, "Location",
                Toast.LENGTH_SHORT).show()
        }
        binding.navProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}