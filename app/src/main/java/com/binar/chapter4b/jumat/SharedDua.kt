package com.binar.chapter4b.jumat

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.activity_shared_dua.*

class SharedDua : AppCompatActivity() {
    lateinit var sf :SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_dua)
        sf = getSharedPreferences("contoh", Context.MODE_PRIVATE)
        val getNama = sf.getString("NAMA","")
        textShared.text = getNama
        logout.setOnClickListener {
            logout()
        }
    }

    fun logout(){
        val logoutsf = sf.edit()
        logoutsf.clear()
        logoutsf.apply()

        startActivity(Intent(this, Shared::class.java))
        finish()
    }
}