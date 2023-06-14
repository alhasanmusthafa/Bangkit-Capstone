package com.example.donorgo.activity.maps

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import com.example.donorgo.R
import com.example.donorgo.activity.event.EventActivity
import com.example.donorgo.activity.home.HomeActivity
import com.example.donorgo.activity.news.NewsActivity
import com.example.donorgo.activity.profile.ProfileActivity
import com.example.donorgo.databinding.ActivityMapsRequestBinding

class MapsRequestActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMapsRequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        init()
    }

    private fun init() {
        with(binding) {
            // Button Navigation
            homeBtn.setOnClickListener(this@MapsRequestActivity)
            eventBtn.setOnClickListener(this@MapsRequestActivity)
            listRequestMapsBtn.setOnClickListener(this@MapsRequestActivity)
            newsBtn.setOnClickListener(this@MapsRequestActivity)
            profileBtn.setOnClickListener(this@MapsRequestActivity)
        }
    }

    override fun onClick(v: View?) {
        // Button Navigation
        when(v?.id) {
            R.id.home_btn -> { startActivity(Intent(this@MapsRequestActivity, HomeActivity::class.java)) }
            R.id.event_btn -> { startActivity(Intent(this@MapsRequestActivity, EventActivity::class.java)) }
            R.id.list_request_maps_btn -> {}
            R.id.news_btn -> { startActivity(Intent(this@MapsRequestActivity, NewsActivity::class.java)) }
            R.id.profile_btn -> { startActivity(Intent(this@MapsRequestActivity, ProfileActivity::class.java)) }
        }
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }
}