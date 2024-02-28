package com.example.aplikasikpu.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasikpu.R


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val waktu_loading = 3000
        Handler().postDelayed(Runnable {
            val homeIntent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(homeIntent)
            finish()
        }, waktu_loading.toLong())
    }
}