package com.dicoding.androidaplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)

        val splashScreenDuration = 3000L
        val moveActivityIntent = Intent(this, MainActivity::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            delay(splashScreenDuration)
            startActivity(moveActivityIntent)
            finish()
        }
    }
}