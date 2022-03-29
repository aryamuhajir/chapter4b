package com.binar.chapter4b.latihan1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.binar.chapter4b.R
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        button1.setOnClickListener {
            val aa = AlertDialog.Builder(this)
            val bb = aa.create()
                aa.setTitle("PERKENALAN")
                aa.setMessage("HELLO WORLD")
                aa.setIcon(R.drawable.ic_launcher_background)
                .show()
        }

        button2.setOnClickListener {
            var angka1 = angka1.text.toString().toInt()
            var angka2 = angka2.text.toString().toInt()
            var hasil = angka1 * angka2
            val aa = AlertDialog.Builder(this)
            val bb = aa.create()
            aa.setTitle("PERKALIAN")
            aa.setMessage("$angka1 x $angka2 = $hasil")
            aa.setIcon(R.drawable.ic_launcher_background)
            aa.setNeutralButton("Keluar"){dialog : DialogInterface, i : Int ->
                bb.dismiss()
            }.show()
        }
    }
}