package com.example.warala.ui.event_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityEventDetailBinding
import com.example.warala.ui.home.HomeActivity

class EventDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ View map
        binding.btnViewMap.setOnClickListener {
            Toast.makeText(this, "Opening map...",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Add to calendar
        binding.btnAddCalendar.setOnClickListener {
            Toast.makeText(this, "Added to calendar!",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ See organizer
        binding.btnSeeOrganizer.setOnClickListener {
            Toast.makeText(this, "Commercial Bank",
                Toast.LENGTH_SHORT).show()
        }

        // ✅ Volunteer button → Thank You page
        binding.btnVolunteer.setOnClickListener {
            startActivity(Intent(this, ThankYouActivity::class.java))
            finish()
        }

        // ✅ LOG COLLECTED WASTE button
        binding.btnLogWaste.setOnClickListener {
            startActivity(Intent(this, LogWasteActivity::class.java))
        }

        // ✅ See other events
        binding.tvSeeOther.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
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