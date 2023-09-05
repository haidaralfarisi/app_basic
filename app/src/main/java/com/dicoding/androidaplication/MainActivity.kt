package com.dicoding.androidaplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvTanaman: RecyclerView
    private val list = ArrayList<Tanaman>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvTanaman = findViewById(R.id.rv_tanaman)
        rvTanaman.setHasFixedSize(true)
        list.addAll(getListTanaman())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun getListTanaman(): ArrayList<Tanaman> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataManfaat = resources.getStringArray(R.array.data_manfaat)

        val listTanaman = ArrayList<Tanaman>()
        for (i in dataName.indices) {
            val tanaman = Tanaman(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataManfaat[i])
            listTanaman.add(tanaman)

        }
        return listTanaman
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showRecyclerList() {
        rvTanaman.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list){
            val intent=Intent(this, DetailActivity::class.java)
            intent.putExtra("Detail",it)
            startActivity(intent)
        }
        rvTanaman.adapter = listHeroAdapter
    }
}