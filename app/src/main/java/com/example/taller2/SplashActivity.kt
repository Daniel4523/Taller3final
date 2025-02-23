package com.example.taller2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

import android.os.Handler
import android.os.Looper

class SplashActivity: AppCompatActivity() {
    private val splashTimeOut: Long = 5000 // 5 segundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, loginActivity::class.java) // Nombre corregido
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
}