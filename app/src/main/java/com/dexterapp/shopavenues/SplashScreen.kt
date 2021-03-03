package com.dexterapp.shopavenues

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dexterapp.shopavenues.login.LoginActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val mainIntent = Intent(this, LoginActivity::class.java)
            startActivity(mainIntent)
            overridePendingTransition(0, 0)
            finish()
        }, 3000)
    }
}