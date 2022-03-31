package com.binar.chapter4b.kamis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.activity_kamis.*

class Kamis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kamis)

        val dataAplikasi = arrayListOf(
            DataAPK(com.google.android.material.R.drawable.ic_clock_black_24dp ,"Binar", "Binar Academy", "Education", 5, "100Mb", "1k"),
            DataAPK(com.google.android.material.R.drawable.ic_clock_black_24dp ,"Binar", "Binar Academy", "Education", 5, "100Mb", "1k"),
            DataAPK(com.google.android.material.R.drawable.ic_clock_black_24dp ,"Binar", "Binar Academy", "Education", 5, "100Mb", "1k")

        )
        val adapt = AdapterAPK(dataAplikasi)
        val laymanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvmahasiswa.layoutManager = laymanager
        rvmahasiswa.adapter = adapt

    }
}