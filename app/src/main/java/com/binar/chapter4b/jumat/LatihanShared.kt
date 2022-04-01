package com.binar.chapter4b.jumat

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.activity_latihan_shared.*
import kotlinx.android.synthetic.main.activity_shared.*
import kotlinx.android.synthetic.main.activity_shared_dua.*

class LatihanShared : AppCompatActivity() {
    lateinit var prefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latihan_shared)

        prefs = getSharedPreferences("latihan", Context.MODE_PRIVATE)
        val getID = prefs.getString("ID","")
        val getNama = prefs.getString("NAMA2","")
        txtNama1.text = getNama
        txtID.text = getID

        btnView.setOnClickListener {
            view()
        }
        btnClear.setOnClickListener {
            txtNama1.text = ""
            txtID.text = ""
            clear()
        }




        save()

    }
    fun save(){
        btnSave.setOnClickListener {
            val sf = prefs.edit()
            val dataID = idLatihan.text.toString()
            val nama = namaLatihan.text.toString()
            sf.putString("ID", dataID)
            sf.putString("NAMA2", nama)
            sf.apply()
        }
    }
    fun view(){
        val getID = prefs.getString("ID","")
        val getNama = prefs.getString("NAMA2","")
        txtNama1.text = getNama
        txtID.text = getID
    }
    fun clear(){
        val clearsf = prefs.edit()
        clearsf.clear()
        clearsf.apply()
    }
}