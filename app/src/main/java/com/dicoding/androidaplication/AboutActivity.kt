package com.dicoding.androidaplication

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_about)
        }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Kode yang akan dijalankan ketika tombol "Back" di ActionBar diklik
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}