package com.binar.chapter4b.jumat

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.activity_shared.*

class Shared : AppCompatActivity() {
    lateinit var prefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)
        if (getSharedPreferences("contoh", Context.MODE_PRIVATE).contains("NAMA")){
            startActivity(Intent(this, SharedDua::class.java))
            finish()
        }

        prefs = getSharedPreferences("contoh", Context.MODE_PRIVATE)


        sharedPrefExample()



    }
    fun sharedPrefExample(){
        btnShared.setOnClickListener {
            val sf = prefs.edit()
            val datanama = editN.text.toString()
            sf.putString("NAMA", datanama)
            sf.apply()

            startActivity(Intent(this,SharedDua::class.java))
            finish()
        }
    }
}