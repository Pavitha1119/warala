package com.example.warala.ui.event_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.warala.databinding.ActivityThankYouBinding
import com.example.warala.ui.home.HomeActivity

class ThankYouActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThankYouBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThankYouBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ BACK TO HOME button
        binding.btnBackToHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}

