package com.dicoding.androidaplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.androidaplication.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shareButton = findViewById<Button>(R.id.btn_share)

        //Icon back Action Bar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)



        shareButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // Membuat intent untuk berbagi teks
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Pesan yang ingin Anda bagikan")

                // Membuat dialog pemilih aplikasi untuk berbagi
                val chooser = Intent.createChooser(intent, "Pilih aplikasi berbagi")

                // Memulai aktivitas pemilih aplikasi
                startActivity(chooser)
            }
        })

        val tanaman = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Tanaman>("Detail", Tanaman::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Tanaman>("Detail")
        }

        if (tanaman != null) {
            binding.tvDetailName.text = tanaman.name
            binding.tvDetailDescription.text = tanaman.description
            binding.tvManfaat.text = tanaman.manfaat
            binding.ivDetailPhoto.setImageResource(tanaman.photo)
        }
    }

}