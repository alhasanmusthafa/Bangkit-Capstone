package com.example.donorgo.activity.news

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donorgo.R
import com.example.donorgo.activity.home.HomeActivity
import com.example.donorgo.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var binding: ActivityNewsBinding
    private lateinit var rvNewss: RecyclerView
    private val list = ArrayList<News>()

    //tasyaa

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        init()

        rvNewss = binding.rvNews
        rvNewss.setHasFixedSize(true)

        list.addAll(NewsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvNewss.layoutManager = LinearLayoutManager(this)
        val academyAdapter = ListNewsAdapter(list)
        rvNewss.adapter = academyAdapter
    }

    private fun init() {
        with(binding) {
            btBack.setOnClickListener(this@NewsActivity)
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

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.bt_back -> { startActivity(Intent(this@NewsActivity, HomeActivity::class.java)) }
        }
    }
}